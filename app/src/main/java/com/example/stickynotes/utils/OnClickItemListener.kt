package com.example.stickynotes.utils

import com.example.stickynotes.model.ModelNote

interface onClickItemListener {
    fun onClick(modelNote: ModelNote, position: Int)
}