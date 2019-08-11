package ir.arcademy.noteproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.arcademy.noteproject.AppConstants
import ir.arcademy.noteproject.R
import ir.arcademy.noteproject.data.model.Note
import kotlinx.android.synthetic.main.activity_note.*

class NoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        val note:Note = intent.extras?.get(AppConstants.NOTE_KEY) as Note
        titleTxt.text = note.title
        bodyTxt.text = note.body
        dateTimeTxt.text = note.dateTime
        if (note.categories.isNotEmpty()){
            note.categories.forEach {
                categoryTxt.append(it.title + "  ")
            }
        }

    }
}
