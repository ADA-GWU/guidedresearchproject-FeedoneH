package com.mysamples.mvc.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mysamples.mvc.model.domain.Note
import com.mysamples.mvc.model.persistence.NoteDao
import kotlinx.coroutines.*
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(var noteDao: NoteDao) : NoteRepository {


    var notes = MutableLiveData<List<Note>>()

    // Method #1
    //function to insert note in database
    override fun insert(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.insert(note)
        }
    }


    // Method #5
    //function to get all notes in database
    override fun getAllNotes(): List<Note> {
        return noteDao.getAllNotes()
    }


}