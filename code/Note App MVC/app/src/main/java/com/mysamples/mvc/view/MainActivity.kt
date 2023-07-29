package com.mysamples.mvc.view

import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mysamples.mvc.controller.LoginController
import com.mysamples.mvc.databinding.ActivityMainBinding
import com.mysamples.mvc.model.DataAccessLayerImpl
import com.mysamples.mvc.model.domain.Note
import com.mysamples.mvc.model.observer.NotesObserver
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NoteView, NotesObserver {

    @Inject
    lateinit var controller: LoginController


    @Inject
    lateinit var model: DataAccessLayerImpl

    private lateinit var binding: ActivityMainBinding
    val noteAdapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Debug.startMethodTracing("startUp")
        controller.bind(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        controller.initData()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = noteAdapter
        }

        binding.loginBtn.setOnClickListener {
            controller.onLoginButtonClicked()
        }
    }

    override fun onStart() {
        super.onStart()
        model.register(this)
    }

    override fun onResume() {
        super.onResume()
        Debug.stopMethodTracing()
    }

    override fun onStop() {
        super.onStop()
        model.unregister(this)
    }

    override fun getNote() = binding.editText.text.toString()


    override fun noteAdded() {
        showMessage("Note added")
        controller.initData()
    }

    override fun notesLoaded(list: List<Note>) {
        showMessage("Notes")
        Log.i("fidan", "notesLoaded: ${list.toString()}")
        noteAdapter.setData(list)
    }

    override fun notesEmptyLoaded() {
        showMessage("There is no note")
    }


    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
