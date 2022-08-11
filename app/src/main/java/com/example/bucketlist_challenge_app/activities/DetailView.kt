package com.example.bucketlist_challenge_app.activities

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bucketlist_challenge_app.R
import com.example.bucketlist_challenge_app.models.BucketlistEntryModel

class DetailView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_view)

        var bucketlistDetailModel: BucketlistEntryModel? = null
        if (intent.hasExtra(MainActivity.EXTRA_ENTRY_DETAILS)) {
            bucketlistDetailModel =
                intent.getSerializableExtra(MainActivity.EXTRA_ENTRY_DETAILS) as BucketlistEntryModel
        }

        if (bucketlistDetailModel != null) {
            setSupportActionBar(findViewById(R.id.toolbar_entry_detail))
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = bucketlistDetailModel.title

            findViewById<ImageView>(R.id.img_entry_detail).setImageURI(
                Uri.parse(
                    bucketlistDetailModel.imagePath
                )
            )
            findViewById<TextView>(R.id.tv_date_detail).text = bucketlistDetailModel.date
            findViewById<TextView>(R.id.tv_location_detail).text = bucketlistDetailModel.location
            findViewById<TextView>(R.id.tv_description_detail).text =
                bucketlistDetailModel.description
        }
    }
}