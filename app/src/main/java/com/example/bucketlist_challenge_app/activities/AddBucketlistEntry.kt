package com.example.bucketlist_challenge_app.activities

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.example.bucketlist_challenge_app.R
import com.example.bucketlist_challenge_app.database.DatabaseHandler
import com.example.bucketlist_challenge_app.models.BucketlistEntryModel
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.*

class AddBucketlistEntry : AppCompatActivity(), View.OnClickListener {

    private var cal = Calendar.getInstance()
    lateinit var dateSetListener: DatePickerDialog.OnDateSetListener
    private var saveImageToInternalStorage: Uri? = null
    private var mlatitude: Double = 0.0
    private var mlongitude: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_bucketlist_entry)

        setSupportActionBar(findViewById(R.id.toolbar_add_entry))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        findViewById<EditText>(R.id.et_date).setOnClickListener(this)
        findViewById<AppCompatImageView>(R.id.img_add_entry).setOnClickListener(this)
        findViewById<Button>(R.id.btn_save).setOnClickListener(this)

        updateDateInView()

        dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, month)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateInView()
        }
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.et_date -> {
                DatePickerDialog(
                    this@AddBucketlistEntry,
                    dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
            R.id.img_add_entry -> {
                val pictureDialog = AlertDialog.Builder(this@AddBucketlistEntry)
                pictureDialog.setTitle("Aktion auswählen")
                val pictureDialogItems = arrayOf("Foto aus Galerie wählen", "Kamera öffnen")
                pictureDialog.setItems(pictureDialogItems) { _, which ->
                    when (which) {
                        0 -> choosePhotoFromGallery()
                        1 -> takePhotoFromCamera()
                    }
                }
                pictureDialog.show()
            }
            R.id.btn_save -> {
                when {
                    findViewById<EditText>(R.id.et_title).text.isNullOrEmpty() -> {
                        Toast.makeText(
                            this@AddBucketlistEntry,
                            "Bitte Titel eingeben",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    findViewById<EditText>(R.id.et_description).text.isNullOrEmpty() -> {
                        Toast.makeText(
                            this@AddBucketlistEntry,
                            "Bitte Beschreibung eingeben",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    findViewById<EditText>(R.id.et_location).text.isNullOrEmpty() -> {
                        Toast.makeText(
                            this@AddBucketlistEntry,
                            "Bitte Ort eingeben",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    saveImageToInternalStorage == null -> {
                        Toast.makeText(
                            this@AddBucketlistEntry,
                            "Bitte Bild auswählen",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else -> {
                        val bucketlistEntryModel = BucketlistEntryModel(
                            0,
                            findViewById<EditText>(R.id.et_title).text.toString(),
                            saveImageToInternalStorage.toString(),
                            findViewById<EditText>(R.id.et_description).text.toString(),
                            findViewById<EditText>(R.id.et_date).text.toString(),
                            findViewById<EditText>(R.id.et_location).text.toString(),
                            mlatitude,
                            mlongitude
                        )
                        val dbHandler = DatabaseHandler(this)
                        val bucketlistEntry = dbHandler.addBucketlistEntry(bucketlistEntryModel)

                        if (bucketlistEntry > 0) {
                            setResult(Activity.RESULT_OK)
                            finish()
                        }
                    }
                }
            }
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == GALLERY_REQUEST_CODE) {
                if (data != null) {
                    val contentURI = data.data
                    try {
                        val selectedImageBitmap =
                            MediaStore.Images.Media.getBitmap(this.contentResolver, contentURI)
                        saveImageToInternalStorage =
                            saveImageToInternalStorage(selectedImageBitmap)
                        findViewById<AppCompatImageView>(R.id.img_add_entry).setImageBitmap(
                            selectedImageBitmap
                        )
                    } catch (e: IOException) {
                        e.printStackTrace()
                        Toast.makeText(
                            this@AddBucketlistEntry,
                            "Laden fehlgeschlagen!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } else if (requestCode == CAMERA_REQUEST_CODE) {
                if (data != null) {
                    val thumbNail: Bitmap = data.extras!!.get("data") as Bitmap
                    try {
                        saveImageToInternalStorage = saveImageToInternalStorage(thumbNail)
                        findViewById<AppCompatImageView>(R.id.img_add_entry).setImageBitmap(
                            thumbNail
                        )
                    } catch (e: IOException) {
                        e.printStackTrace()
                        Toast.makeText(
                            this@AddBucketlistEntry,
                            "Laden fehlgeschlagen!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun updateDateInView() {
        val dateFormat = "dd.MM.yyyy"
        val sdf = SimpleDateFormat(dateFormat, Locale.getDefault())
        findViewById<EditText>(R.id.et_date).setText(sdf.format(cal.time).toString())
    }

    private fun takePhotoFromCamera() {
        Dexter.withActivity(this).withPermissions(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        ).withListener(object : MultiplePermissionsListener {
            override fun onPermissionsChecked(
                report: MultiplePermissionsReport?
            ) {
                if (report!!.areAllPermissionsGranted()) {
                    val cameraIntent =
                        Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
                }
            }

            override fun onPermissionRationaleShouldBeShown(
                permissions: MutableList<PermissionRequest>?,
                token: PermissionToken?
            ) {
                showRationalDialogForPermissions()
            }

        }).onSameThread().check()
    }

    private fun choosePhotoFromGallery() {
        Dexter.withActivity(this).withPermissions(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ).withListener(object : MultiplePermissionsListener {
            override fun onPermissionsChecked(
                report: MultiplePermissionsReport?
            ) {
                if (report!!.areAllPermissionsGranted()) {
                    val galleryIntent =
                        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE)
                }
            }

            override fun onPermissionRationaleShouldBeShown(
                permissions: MutableList<PermissionRequest>?,
                token: PermissionToken?
            ) {
                showRationalDialogForPermissions()
            }

        }).onSameThread().check()
    }

    private fun showRationalDialogForPermissions() {
        AlertDialog.Builder(this@AddBucketlistEntry).setMessage(
            "Es sieht so aus als hättest du die Berechtigungen für das Hinzufügen von Bildern verweigert. In den Einstellungen kannst du dieser App die notwendigen Berechtigungen erteilen."
        )
            .setPositiveButton("ZU DEN EINSTELLUNGEN") { _, _ ->
                try {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri.fromParts("package", packageName, null)
                    intent.data = uri
                    startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    e.printStackTrace()
                }
            }

            .setNegativeButton("Abbrechen") { dialog, _ ->
                dialog.dismiss()
            }.show()
    }

    private fun saveImageToInternalStorage(bitmap: Bitmap): Uri {
        val wrapper = ContextWrapper(applicationContext)
        var file = wrapper.getDir(IMAGE_DIR, Context.MODE_PRIVATE)
        file = File(file, "${UUID.randomUUID()}.jpg")

        try {
            val stream: OutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return Uri.parse(file.absolutePath)
    }

    companion object {
        private const val GALLERY_REQUEST_CODE = 164846835
        private const val CAMERA_REQUEST_CODE = 418464438
        private const val IMAGE_DIR = "Bucketlist-App"
    }
}