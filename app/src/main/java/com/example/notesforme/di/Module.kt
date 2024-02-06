package com.example.notesforme.di

import android.content.Context
import androidx.room.Room
import com.example.notesforme.NotesDao
import com.example.notesforme.Notesdb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object Module {


    @Singleton
    @Provides
    fun providesDao(noteDatabase : Notesdb) : NotesDao
    = noteDatabase.notes_dao()



    @Singleton
    @Provides
    fun providesNotesDatabase(@ApplicationContext context:Context) : Notesdb
    = Room.databaseBuilder(
        context,
        Notesdb::class.java,
        "notes_db")
        .fallbackToDestructiveMigration()
        .build()



}
//345