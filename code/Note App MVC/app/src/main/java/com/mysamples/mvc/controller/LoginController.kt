package com.mysamples.mvc.controller

import com.mysamples.mvc.model.DataAccessLayerImpl
import com.mysamples.mvc.model.domain.Note
import com.mysamples.mvc.view.NoteView
import javax.inject.Inject


class LoginController @Inject constructor(private val model: DataAccessLayerImpl) {

    private lateinit var view: NoteView

    fun bind(noteView: NoteView) {
        view = noteView
    }

    fun initData() {
        model.getNoteList()
    }

    fun onLoginButtonClicked() {
        model.insertNote(Note(Math.random().toInt(), view.getNote()))
    }

}