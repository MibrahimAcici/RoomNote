package com.ibrahim.roomnote.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ibrahim.roomnote.db.dao.NoteDao
import com.ibrahim.roomnote.db.entity.NoteEntity

@Database(entities = [NoteEntity::class],version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun notedao(): NoteDao

}

