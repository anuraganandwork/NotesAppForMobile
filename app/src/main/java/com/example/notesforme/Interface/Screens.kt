package com.example.notesforme.Interface

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.notesforme.ViewModel.NoteVm
import com.example.notesforme.model.Note
import com.example.notesforme.notesCard

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Screen(v:NoteVm){

    val keyboardController = LocalSoftwareKeyboardController.current

    var id by remember{
        mutableStateOf("")
    }


    var title by remember{
        mutableStateOf("")
    }
    var description by remember{
        mutableStateOf("")
    }

    val list  = v.notelist.collectAsState().value
    Column {

        OutlinedTextField(value = id , onValueChange = { id=it}, label = { Text(text = "Note no.")}, keyboardOptions = KeyboardOptions(imeAction =ImeAction.Done, keyboardType = KeyboardType.Number),
            keyboardActions = KeyboardActions(
                onDone = {keyboardController?.hide()}
            )
        )




       OutlinedTextField(value = title , onValueChange = { title=it}, label = { Text(text = "Enter title")}, keyboardOptions = KeyboardOptions(imeAction =ImeAction.Done),
           keyboardActions = KeyboardActions(
               onDone = {keyboardController?.hide()}
           )
       )

        OutlinedTextField(value = description , onValueChange = { description=it}, label = { Text(text = "Enter description")}, keyboardOptions = KeyboardOptions(imeAction =ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {keyboardController?.hide()}
            ))

        Button(onClick = {
            v.addNote(Note(id.toInt(),title,description))
            title=""
            description=""
            id=""
        }, colors = ButtonDefaults.buttonColors( Color(127, 0, 255))

        )  {
            Text(text = "Add note", color = Color.White)
        }
        
        Spacer(modifier = Modifier.padding(20.dp))
        LazyColumn(
        ){
   items(
         list
   ){
        notesCard(note = it,v)
       Spacer(modifier = Modifier.height(5.dp))
   }

    }
}}

//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