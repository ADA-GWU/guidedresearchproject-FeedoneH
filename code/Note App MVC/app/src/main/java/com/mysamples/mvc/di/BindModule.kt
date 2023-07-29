package com.mysamples.mvc.di

import com.mysamples.mvc.model.DataAccessLayerImpl
import com.mysamples.mvc.model.DataAccessLayer
import com.mysamples.mvc.model.NoteRepository
import com.mysamples.mvc.model.NoteRepositoryImpl
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

    @Singleton
    @Binds
    abstract fun bindDataLayer(dataLayer: DataAccessLayerImpl): DataAccessLayer


}