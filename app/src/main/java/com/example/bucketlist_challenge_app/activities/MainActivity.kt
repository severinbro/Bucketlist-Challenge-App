package com.example.bucketlist_challenge_app.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bucketlist_challenge_app.R
import com.example.bucketlist_challenge_app.adapters.BucketlistEntriesAdapter
import com.example.bucketlist_challenge_app.database.DatabaseHandler
import com.example.bucketlist_challenge_app.models.BucketlistEntryModel
import pl.kitek.rvswipetodelete.SwipeToEditCallback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabAddItem: View = findViewById<Button>(R.id.fabAddItem)
        fabAddItem.setOnClickListener {
            val intent = Intent(this, AddBucketlistEntry::class.java)
            startActivityForResult(intent, ADD_ENTRY_REQUEST_CODE)
        }
        getBucketlistEntriesListFromLocalDB()
    }

    private fun setupBucketlistEntriesRecyclerView(bucketlistEntriesList: ArrayList<BucketlistEntryModel>) {
        val rv_bucketlist_entries_list = findViewById<RecyclerView>(R.id.rv_bucketlist_entries_list)

        rv_bucketlist_entries_list.layoutManager =
            LinearLayoutManager(this)
        rv_bucketlist_entries_list.setHasFixedSize(true)

        val entriesAdapter = BucketlistEntriesAdapter(this, bucketlistEntriesList)
        rv_bucketlist_entries_list.adapter = entriesAdapter

        entriesAdapter.setOnClickListener(object: BucketlistEntriesAdapter.OnClickListener{
            override fun onClick(position: Int, model: BucketlistEntryModel) {
                val intent = Intent(this@MainActivity, DetailView::class.java)
                intent.putExtra(EXTRA_ENTRY_DETAILS, model)
                startActivity(intent)
            }
        })

        val editSwipeHandler = object : SwipeToEditCallback(this){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = rv_bucketlist_entries_list.adapter as BucketlistEntriesAdapter
                adapter.notifyEditItem(this@MainActivity, viewHolder.adapterPosition, ADD_ENTRY_REQUEST_CODE)
            }
        }

        val editItemTouchHelper = ItemTouchHelper(editSwipeHandler)
        editItemTouchHelper.attachToRecyclerView(rv_bucketlist_entries_list)

    }

    private fun getBucketlistEntriesListFromLocalDB() {
        val dbHandler = DatabaseHandler(this)
        val getBucketlistEntriesList: ArrayList<BucketlistEntryModel> =
            dbHandler.getBucketlistEntriesList()

        if (getBucketlistEntriesList.size > 0) {
            findViewById<RecyclerView>(R.id.rv_bucketlist_entries_list).visibility = View.VISIBLE
            findViewById<TextView>(R.id.tv_no_entries_yet).visibility = View.GONE
            setupBucketlistEntriesRecyclerView(getBucketlistEntriesList)
        } else {
            findViewById<RecyclerView>(R.id.rv_bucketlist_entries_list).visibility = View.GONE
            findViewById<TextView>(R.id.tv_no_entries_yet).visibility = View.VISIBLE
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == ADD_ENTRY_REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                getBucketlistEntriesListFromLocalDB()
            }else{
                Log.e("Activity", "Cancelled or back pressed")
            }
        }
    }
    companion object {
        var ADD_ENTRY_REQUEST_CODE = 65133816
        var EXTRA_ENTRY_DETAILS = "extra_entry_details"
    }
}