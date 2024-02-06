package com.example.notesforme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesforme.Interface.Screen
import com.example.notesforme.ViewModel.NoteVm
import com.example.notesforme.model.Note
import com.example.notesforme.ui.theme.NotesForMeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm by viewModels<NoteVm>()


        setContent {
            NotesForMeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen(v = vm)
                }
            }
        }
    }
}

//fun main()
@Composable
//fun Screen(vm: NoteVm){
//    val list = vm.notelist.collectAsState().value
//    val note:Note= Note(1,"Anurag","anuraganandwork")
//    val note2:Note= Note(2,"Anand","assdsafdsfds")
//vm.addNote(note)
//    vm.addNote(note2)
//    Column {
//
//
//LazyColumn(){
//    items(
//        items = list
//    ){
//        notesCard(note = it)
//    }
//}}
//
//
//
//}
fun notesCard(note: Note, vb:NoteVm){
//    RGB(179, 155, 216)



        Box(Modifier.fillMaxWidth()) {


    Column(Modifier
        .clip(
            RoundedCornerShape(10.dp)
        ).align(Alignment.Center)
        .background(Color(red = 179, 155, 216))
        .padding(8.dp)
        .clickable(onClick = { vb.deleteNote(note) })
        .width(270.dp)) {
        Text(text = note.title, fontSize = 20.sp)
        Text(text = note.description, fontSize = 15.sp)
//        145
//        Icon(painter = painterResource(id = R.drawable.delete), contentDescription = "Del icon"
//        , modifier = Modifier.clickable {  })
    }
}}

