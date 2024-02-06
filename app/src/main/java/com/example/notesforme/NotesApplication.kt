package com.example.notesforme

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NotesApplication : Application() {

}

//this class is the storage room for all the supplies that other class wants
//this is the dependency container at the application level