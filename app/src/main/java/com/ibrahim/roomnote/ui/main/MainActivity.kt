package com.ibrahim.roomnote.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.ibrahim.roomnote.databinding.ActivityMainBinding
import com.ibrahim.roomnote.db.AppDatabase
import com.ibrahim.roomnote.ui.createNote.CreateNoteActivity
import com.ibrahim.roomnote.ui.main.adapter.NoteAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDatabase()
        initAdapter()
        fetchNoteList()

        initClickListeners()
    }
    private fun initDatabase() {
        db= Room.databaseBuilder(this, AppDatabase::class.java, "notes")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    private fun initAdapter() {
        noteAdapter = NoteAdapter()
        binding.recyclerview.adapter = noteAdapter

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        binding.recyclerview.layoutManager =layoutManager

    }
    private fun fetchNoteList() {
        val list = db.notedao().getAllNotes()
        noteAdapter.setList(list)
    }
    private fun initClickListeners() {
        binding.btnPlus.setOnClickListener {
            val intent = Intent(this, CreateNoteActivity::class.java)
            startActivity(intent)
        }
    }




}