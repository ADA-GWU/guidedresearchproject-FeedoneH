package com.mysamples.mvp.di

import android.content.Context
import androidx.room.Room
import com.mysamples.mvp.model.persistence.NoteDao
import com.mysamples.mvp.model.persistence.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Provide all the app level dependency here
@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Singleton
    @Provides
    fun providesNoteDao(db: NoteDatabase): NoteDao {
        return db.noteDao()
    }
//
//
    @Singleton
    @Provides
    fun providesAppDatabase(@ApplicationContext app: Context): NoteDatabase {
        return Room.databaseBuilder(app, NoteDatabase::class.java, "note_database")
            .allowMainThreadQueries().build()
    }
}