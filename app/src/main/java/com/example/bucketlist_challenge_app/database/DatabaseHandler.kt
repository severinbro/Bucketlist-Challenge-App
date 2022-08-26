package com.example.bucketlist_challenge_app.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.bucketlist_challenge_app.models.BucketlistEntryModel
import com.example.bucketlist_challenge_app.utils.Constants
import java.sql.SQLException

class DatabaseHandler(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "BucketlistDatabase"
        private const val TABLE_NAME = "BucketlistTable"

        // Column names
        private const val KEY_ID = "_id"
        private const val KEY_TITLE = "title"
        private const val KEY_IMAGE = "image"
        private const val KEY_DESCRIPTION = "description"
        private const val KEY_DATE = "date"
        private const val KEY_LOCATION = "location"
        private const val KEY_LATITUDE = "latitude"
        private const val KEY_LONGITUDE = "longitude"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val CREATE_BUCKETLIST_TABLE = ("CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_TITLE + " TEXT,"
                + KEY_IMAGE + " TEXT,"
                + KEY_DESCRIPTION + " TEXT,"
                + KEY_DATE + " TEXT,"
                + KEY_LOCATION + " TEXT,"
                + KEY_LATITUDE + " TEXT,"
                + KEY_LONGITUDE + " TEXT)")
        p0?.execSQL(CREATE_BUCKETLIST_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(p0)
    }

    fun addBucketlistEntry(listEntry: BucketlistEntryModel): Long {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(KEY_TITLE, listEntry.title)
        contentValues.put(KEY_IMAGE, listEntry.imagePath)
        contentValues.put(KEY_DESCRIPTION, listEntry.description)
        contentValues.put(KEY_DATE, listEntry.date)
        contentValues.put(KEY_LOCATION, listEntry.location)
        contentValues.put(KEY_LONGITUDE, listEntry.longitude)
        contentValues.put(KEY_LATITUDE, listEntry.latitude)

        val result = db.insert(TABLE_NAME, null, contentValues)

        db.close()
        return result
    }

    fun updateBucketlistEntry(listEntry: BucketlistEntryModel): Int {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(KEY_TITLE, listEntry.title)
        contentValues.put(KEY_IMAGE, listEntry.imagePath)
        contentValues.put(KEY_DESCRIPTION, listEntry.description)
        contentValues.put(KEY_DATE, listEntry.date)
        contentValues.put(KEY_LOCATION, listEntry.location)
        contentValues.put(KEY_LONGITUDE, listEntry.longitude)
        contentValues.put(KEY_LATITUDE, listEntry.latitude)

        val success = db.update(TABLE_NAME, contentValues, KEY_ID + "=" + listEntry.id, null)

        db.close()
        return success
    }

    fun deleteBucketlistEntry(listEntry: BucketlistEntryModel) : Int {
        val db = this.writableDatabase
        val success = db.delete(TABLE_NAME, KEY_ID + "=" + listEntry.id, null)
        db.close()
        return success
    }

    @SuppressLint("Range")
    fun getBucketlistEntriesList(): ArrayList<BucketlistEntryModel> {
        val bucketListEntriesList = ArrayList<BucketlistEntryModel>()
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase

        try {
            val cursor: Cursor = db.rawQuery(selectQuery, null)
            if (cursor.moveToFirst()) {
                do {
                    val entry = BucketlistEntryModel(
                        cursor.getInt(cursor.getColumnIndex(KEY_ID)),
                        cursor.getString(cursor.getColumnIndex(KEY_TITLE)),
                        cursor.getString(cursor.getColumnIndex(KEY_IMAGE)),
                        cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)),
                        cursor.getString(cursor.getColumnIndex(KEY_DATE)),
                        cursor.getString(cursor.getColumnIndex(KEY_LOCATION)),
                        cursor.getDouble(cursor.getColumnIndex(KEY_LATITUDE)),
                        cursor.getDouble(cursor.getColumnIndex(KEY_LONGITUDE))
                    )
                    bucketListEntriesList.add(entry)
                } while (cursor.moveToNext())
            }
            cursor.close()
        } catch (e: SQLException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        return bucketListEntriesList
    }

}