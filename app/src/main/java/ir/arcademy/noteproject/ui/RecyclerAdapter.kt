package ir.arcademy.noteproject.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.arcademy.noteproject.AppConstants
import ir.arcademy.noteproject.R
import ir.arcademy.noteproject.data.model.Note
import kotlinx.android.synthetic.main.item_layout.view.*

class RecyclerAdapter(var notes: List<Note>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.titleTxt.text = notes[position].title
        holder.itemView.dateTimeTxt.text = notes[position].dateTime

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, NoteActivity::class.java)
            intent.putExtra(AppConstants.NOTE_KEY, notes[position])
            holder.itemView.context.startActivity(intent)
        }

        holder.itemView.editBtn.setOnClickListener {
            val intent = Intent(holder.itemView.context, SaveNoteActivity::class.java)
            intent.putExtra(AppConstants.STATE_KEY, AppConstants.UPDATE_STATE)
            intent.putExtra(AppConstants.NOTE_KEY, notes[position])
            holder.itemView.context.startActivity(intent)
        }

        holder.itemView.deleteBtn.setOnClickListener {

        }

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}