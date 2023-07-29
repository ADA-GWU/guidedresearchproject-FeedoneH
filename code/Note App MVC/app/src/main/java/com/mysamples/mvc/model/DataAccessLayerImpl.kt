package com.mysamples.mvc.model

import android.util.Log
import com.mysamples.mvc.model.domain.Note
import com.mysamples.mvc.model.observer.NotesObserver
import com.mysamples.mvc.model.observer.DomainObserver
import javax.inject.Inject


class DataAccessLayerImpl @Inject constructor(
    private val noteRepository: NoteRepository
) : DataAccessLayer {


    override var observers: MutableList<DomainObserver> = mutableListOf<DomainObserver>()


    override fun register(observer: DomainObserver): Boolean {
        Log.i("fidan", "register: fidan")
        return observers.add(observer)
    }

    override fun unregister(observer: DomainObserver) = observers.remove(observer)

    override fun insertNote(note: Note) {
        noteRepository.insert(note)
        notify(NotesObserver::noteAdded)
    }

    override fun getNoteList() {
        Log.i("fidan", "getNoteList: ")
        val notes = noteRepository.getAllNotes()
        Log.i("fidan", "getNoteList1: ${notes}")
        notify(NotesObserver::notesEmptyLoaded)
        notify {
            it.notesLoaded(notes ?: listOf())
        }
        if (!notes.isNullOrEmpty()) {
        } else {
            notify(NotesObserver::notesEmptyLoaded)
        }
    }

    private fun notify(action: (NotesObserver) -> Unit) {
        observers.filterIsInstance<NotesObserver>().onEach { action(it) }
    }
}