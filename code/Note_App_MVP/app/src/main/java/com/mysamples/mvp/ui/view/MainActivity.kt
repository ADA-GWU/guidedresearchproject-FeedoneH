package com.mysamples.mvp.ui.view

import android.os.Bundle
import android.os.Debug
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mysamples.mvp.databinding.ActivityMainBinding
import com.mysamples.mvp.model.domain.Note
import com.mysamples.mvp.ui.NoteAdapter
import com.mysamples.mvp.ui.NotePresenter
import com.mysamples.mvp.ui.NoteView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NoteView {

    @Inject
    lateinit var presenter: NotePresenter


    private lateinit var binding: ActivityMainBinding
    val noteAdapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Debug.startMethodTracing("startUp")
        presenter.view = this
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.getNotes()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = noteAdapter
        }

        binding.loginBtn.setOnClickListener {
            presenter.addNote(
                Note(
                    title = binding.editText.text.toString(),
                    id = Math.random().toInt()
                )
            )
        }
    }


    override fun onResume() {
        super.onResume()
        Debug.stopMethodTracing()
    }


    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onGetNotes(response: List<Note>) {
        runOnUiThread {
            noteAdapter.setData(response)
        }
    }

    override fun onAddNote() {
        presenter.getNotes()
    }

}
