package com.mysamples.mvp.ui


interface NoteContractor {
    interface Presenter {
        fun getNotes()
        fun addNote(note: com.mysamples.mvp.model.domain.Note)
    }
}