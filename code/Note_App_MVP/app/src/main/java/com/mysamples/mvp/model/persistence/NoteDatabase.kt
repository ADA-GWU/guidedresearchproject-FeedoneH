package com.mysamples.mvp.model.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mysamples.mvp.model.domain.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}