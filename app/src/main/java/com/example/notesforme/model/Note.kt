package com.example.notesforme.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "notes_tbl")
data class Note(

    @PrimaryKey
    val id:Int,

    @ColumnInfo(name = "titles")
    val title: String,

    @ColumnInfo(name ="description")
    val description: String
)
