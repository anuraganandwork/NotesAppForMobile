package com.example.notesforme.Repository

import android.util.Log
import com.example.notesforme.NotesDao
import com.example.notesforme.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repo @Inject constructor(private val notesDao: NotesDao) {

    suspend fun addNote(note : Note) = notesDao.insertNote(note)
    suspend fun updateNote(note : Note)= notesDao.update(note)
    suspend fun deleteNote(note: Note){
        notesDao.deleteNote(note)
        Log.d("NoteVmm", "Deleting note: ")
    }
      fun getAllNote(): Flow<List<Note>> = notesDao.getNotes().flowOn(Dispatchers.IO).conflate()
}

//flow contains stream of the value, whereas stateflow contain only one value at a time anf it keeps  updating to the obsrver when the value chnagfes