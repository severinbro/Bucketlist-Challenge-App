package com.example.bucketlist_challenge_app.firebase

import com.example.bucketlist_challenge_app.activities.AddBucketlistEntry
import com.example.bucketlist_challenge_app.models.BucketlistEntryModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class FirestoreClass {

    private val mFireStore = FirebaseFirestore.getInstance()

    fun registerBucketlistEntry(activity: AddBucketlistEntry, listEntryModel: BucketlistEntryModel){
        mFireStore.collection("BucketlistEntries")
            .document()
            .set(listEntryModel, SetOptions.merge())
    }

}