package com.example.stickynotes

import android.Manifest
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.provider.MediaStore
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.modelNote.R
import com.example.stickynotes.database.NoteDatabase
import com.example.stickynotes.model.ModelNote
import kotlinx.android.synthetic.main.activity_create_note.*
import kotlinx.android.synthetic.main.layout_delete.*
import kotlinx.android.synthetic.main.layout_url.*
import kotlinx.android.synthetic.main.layout_url.view.*
import java.text.SimpleDateFormat
import java.util.*

class CreateNoteActivity : AppCompatActivity(){
    var alertDialog : AlertDialog? = null
    var selectImagePath : String? = null
    var modelNoteExtra : ModelNote? = null

    @SuppressLint("SetTextI18n", "RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        //Hari, Tanggal bulan tahun, jam a = malam m = pagi
        tvDateTime.setText("Terakhir diubah : " + SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(Date()))

        //Image Path
        selectImagePath = ""

        if(intent.getBooleanExtra("EXTRA", false)){
            modelNoteExtra = intent.getSerializableExtra("EXTRA_NOTE") as ModelNote
            setViewOrUpdateNote()
        }

        if (modelNoteExtra != null){
            linearDelete.visibility = View.VISIBLE
            btnDelete.setOnClickListener {
                showDeleteDialog()
            }
        }

        btnHapusUrl.setOnClickListener{
            tvUrlNote.setText(null)
            tvUrlNote.setVisibility(View.GONE)
            btnHapusUrl.setVisibility(View.GONE)
        }

        btnAddUrl.setOnClickListener{
            showDialogUrl()
        }

        btnAddImage.setOnClickListener{
            if(ContextCompat.checkSelfPermission(applicationContext,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this@CreateNoteActivity,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_PERMISSION)
            } else {
                selectImage()
            }
        }

        fabDeleteImage.setOnClickListener{
            imageNote.setImageBitmap(null)
            imageNote.setVisibility(View.GONE)
            fabDeleteImage.setVisibility(View.GONE)
            selectImagePath = ""
        }

    }

    private fun setViewOrUpdateNote() {
        TODO("Not yet implemented")
    }
}