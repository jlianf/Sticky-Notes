package com.example.stickynotes

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @get:Query("SELECT * FROM notes ORDER BY id DESC")
    val allNote: List<ModelNote?>?

    @Insert(onConflict = onConflictStrategy.REPLACE)
    fun insert(modelNote: ModelNote?)

    @Delete
    fun delete(modelNote : ModelNote?)
}