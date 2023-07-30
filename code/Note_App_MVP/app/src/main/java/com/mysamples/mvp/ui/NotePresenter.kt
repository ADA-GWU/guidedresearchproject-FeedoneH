package com.mysamples.mvp.ui

import com.mysamples.mvp.model.NoteRepository
import com.mysamples.mvp.model.domain.Note
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class NotePresenter @Inject constructor(val noteRepository: NoteRepository) {

    var view: NoteView? = null

    fun getNotes() {
        GlobalScope.launch {
            val response = noteRepository.getAllNotes()
            response?.let {
                view?.onGetNotes(it)
            }
        }
    }

    fun addNote(note: Note) {
        GlobalScope.launch {
            val response = noteRepository.insert(note)
            view?.onAddNote()
        }
    }
}