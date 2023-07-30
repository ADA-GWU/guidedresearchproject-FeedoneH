package com.mysamples.mvp.ui

import com.mysamples.mvp.model.domain.Note

interface NoteView {
    fun onGetNotes(response: List<Note>)
    fun onAddNote()
}
