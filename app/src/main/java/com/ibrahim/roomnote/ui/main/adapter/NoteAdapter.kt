package com.ibrahim.roomnote.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.roomnote.databinding.NoteItemBinding
import com.ibrahim.roomnote.db.entity.NoteEntity

class NoteAdapter  : RecyclerView.Adapter<NoteAdapter.NoteVH>() {

    private val notes: ArrayList<NoteEntity> = arrayListOf()

    fun setList(notes:List<NoteEntity>){
        this.notes.clear()
        this.notes.addAll(notes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType : Int): NoteVH {
        return NoteVH(NoteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int=notes.size

    override fun onBindViewHolder(holder: NoteVH, position: Int) {
        val note = notes[position]

        holder.binding.rcTxtTitle.text = note.title
        holder.binding.rcTxtSubject.text = note.subject
        holder.binding.rcTxtDescription.text = note.description

    }

    inner class NoteVH(val binding: NoteItemBinding): RecyclerView.ViewHolder(binding.root) {
    }
}