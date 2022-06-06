package com.ibrahim.roomnote.ui.createNote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.room.Room
import com.ibrahim.roomnote.ui.main.MainActivity
import com.ibrahim.roomnote.databinding.ActivityCreateNoteBinding
import com.ibrahim.roomnote.db.AppDatabase
import com.ibrahim.roomnote.db.entity.NoteEntity

class CreateNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityCreateNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCreateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val db: AppDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java,"notes")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        binding.btnSave.setOnClickListener {

            if(binding.txtTitle.text!!.isEmpty()  || binding.txtSubject.text!!.isEmpty()  || binding.txtDescription.text!!.isEmpty()){

                Toast.makeText(applicationContext, "Empty!!", Toast.LENGTH_SHORT).show()

            }else{
                val note = NoteEntity(binding.txtTitle.text.toString(),binding.txtSubject.text.toString(),binding.txtDescription.text.toString())
                db.notedao().insertNote(note)
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
