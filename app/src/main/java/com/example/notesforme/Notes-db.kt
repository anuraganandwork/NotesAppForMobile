package com.example.notesforme

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notesforme.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class Notesdb: RoomDatabase() {
    abstract  fun notes_dao(): NotesDao
}