package com.mysamples.mvc.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mysamples.mvc.model.domain.Note
import com.mysamples.mvc.model.persistence.NoteDao
import kotlinx.coroutines.*
import javax.inject.Inject

interface NoteRepository{

    fun insert(note: Note)
    fun getAllNotes(): List<Note>?

}