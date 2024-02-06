package com.example.notesforme.ViewModel

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesforme.Repository.Repo
import com.example.notesforme.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteVm  @Inject constructor(val repo: Repo): ViewModel(){


    private var _notelist =  MutableStateFlow<List<Note>>(emptyList())
    val notelist = _notelist.asStateFlow()
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllNote().collect{
                _notelist.value= it
            }
        }

    }


      fun addNote(n: Note)= viewModelScope.launch {  repo.addNote(n)}
     fun deleteNote(notes: Note)= viewModelScope.launch {
         repo.deleteNote(notes)
         Log.d("NoteVm", "Deleting note: ${notes.id}")
     }


}