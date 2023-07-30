package com.mysamples.mvp.di

import com.mysamples.mvp.model.NoteRepository
import com.mysamples.mvp.model.NoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {
    @Singleton
    @Binds
    abstract fun bindrepo(repo: NoteRepositoryImpl): NoteRepository


}