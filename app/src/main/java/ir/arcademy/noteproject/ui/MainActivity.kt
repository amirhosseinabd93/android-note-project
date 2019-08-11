package ir.arcademy.noteproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import ir.arcademy.noteproject.AppConstants
import ir.arcademy.noteproject.R
import ir.arcademy.noteproject.data.model.Note
import ir.arcademy.noteproject.util.DataUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter:RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView(DataUtil.getNotes())
    }

    private fun setRecyclerView(notes:List<Note>){
        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerAdapter(notes)
        mainRecyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.addMenuItem -> {
                val intent = Intent(this@MainActivity, SaveNoteActivity::class.java)
                intent.putExtra(AppConstants.STATE_KEY, AppConstants.CREATE_STATE)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
