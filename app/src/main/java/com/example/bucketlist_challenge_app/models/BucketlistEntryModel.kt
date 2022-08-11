package com.example.bucketlist_challenge_app.models

data class BucketlistEntryModel(
        val id: Int,
        val title: String,
        val imagePath: String,
        val description: String,
        val date: String,
        val location: String,
        val latitude: Double,
        val longitude: Double
)
