package com.example.notesforme

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notesforme.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Query("SELECT * from notes_tbl ")
    fun getNotes(): Flow<List<Note>>

//    1248

    @Query("SELECT * from notes_tbl where id=:id")
    suspend fun getNotesById(id : String):Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun update(note:Note)

    @Delete
    suspend  fun deleteNote(note: Note)
}
