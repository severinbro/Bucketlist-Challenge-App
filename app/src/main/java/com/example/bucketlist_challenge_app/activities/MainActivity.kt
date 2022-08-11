package com.example.bucketlist_challenge_app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.bucketlist_challenge_app.R
import com.example.bucketlist_challenge_app.database.DatabaseHandler
import com.example.bucketlist_challenge_app.models.BucketlistEntryModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabAddItem: View = findViewById<Button>(R.id.fabAddItem)
        fabAddItem.setOnClickListener {
            val intent = Intent(this, AddBucketlistEntry::class.java)
            startActivity(intent)
        }
        getBucketlistEntriesListFromLocalDB()
    }

    private fun getBucketlistEntriesListFromLocalDB(){
        val dbHandler = DatabaseHandler(this)
        val getBucketlistEntriesList : ArrayList<BucketlistEntryModel> = dbHandler.getBucketlistEntriesList()

        if(getBucketlistEntriesList.size > 0){
            for(i in getBucketlistEntriesList) {
                // TODO
            }
        }

    }
}