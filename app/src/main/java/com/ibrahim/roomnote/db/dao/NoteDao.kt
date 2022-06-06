package com.ibrahim.roomnote.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ibrahim.roomnote.db.entity.NoteEntity

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_table")
    fun getAllNotes(): List<NoteEntity>

    @Insert
    fun insertNote(note:NoteEntity)

    @Insert
    fun insertNoteList(noteList:List<NoteEntity>)

    @Query("DELETE from note_table where noteId = :noteId")
    fun deleteById(vararg noteId :Int) :Int
}
