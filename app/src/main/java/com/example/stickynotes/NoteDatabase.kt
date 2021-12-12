package com.example.stickynotes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ModelNote::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase(){

    abstract fun noteDao(): NoteDao?

    companion object {
        private var noteDatabase: NoteDatabase? : null
                @Synchronized
                fun getInstance(context: Context) : NoteDatabase? {
                    if (noteDatabase = null){
                        noteDatabase = Room.databaseBuilder(context, NoteDatabase::class.java, "Notedb").build()
                    }
                    return noteDatabase
                }
    }
}