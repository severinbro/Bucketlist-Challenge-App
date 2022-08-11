package com.example.bucketlist_challenge_app.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bucketlist_challenge_app.R

class DetailView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_view)

        setSupportActionBar(findViewById(R.id.tb_detail_view))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}