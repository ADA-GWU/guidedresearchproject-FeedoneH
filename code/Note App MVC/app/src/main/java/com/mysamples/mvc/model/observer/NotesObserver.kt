package com.mysamples.mvc.model.observer

import com.mysamples.mvc.model.domain.Note


interface NotesObserver : DomainObserver {

    fun noteAdded()

    fun notesLoaded(list: List<Note>)

    fun notesEmptyLoaded()

}