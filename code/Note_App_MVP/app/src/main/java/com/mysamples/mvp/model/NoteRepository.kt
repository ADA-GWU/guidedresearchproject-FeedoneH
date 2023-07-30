package com.mysamples.mvp.model

import com.mysamples.mvp.model.domain.Note

interface NoteRepository{

    fun insert(note: Note)
    fun getAllNotes(): List<Note>?

}