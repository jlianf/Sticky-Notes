package com.example.stickynotes

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.modelNote.R
import com.example.stickynotes.adapter.NoteAdapter
import com.example.stickynotes.databses.NoteDatabase
import com.example.stickynotes.model.ModelNote
import com.example.stickynotes.utils.onClickItemListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), onClickItemListener {

    private val modelNoteList: MutableList<ModelNote> = ArrayList()
    private var noteAdapter: NoteAdapter? = null
    private var onClickPosition = -1

    @SuppressLint("Assert")
    override fun onCreate(savedInstanceState: Bundle=?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)
        assert(supportActionBar != null)

        fabCreateNote.setOnClickListener {
            startActivityForResult(Intent(this@MainActivity, CreateNoteActivity::class.java), REQUEST_ADD)
        }

        noteAdapter = NoteAdapter(modelNoteList, this)
        rvListNote.setAdapter(noteAdapter)

        //change mode List to Grid
        modeGrid()

        //get Data Catatan
        getNote(requestShow = , false)

    }

    private fun modeGrid() {
        rvListNote.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }

    private fun ModeList(){
        rvListNote.layoutManager = LinearLayoutManager(this)
    }

    private fun getNote(requestCode: Int, deleteNote: Boolean) {

        @Suppress("UNCHECKED_CAST")
        class GetNoteAsyncTask : AsyncTask<Void?, Void?, List<ModelNote>>() {
            private fun doInBackground(var p0: Void?): List<ModelNote>?{
                return NoteDatabase.getInstance(this@MainActivity).noteDao().allnote as List<ModelNote>?
            }

        }

    }



}