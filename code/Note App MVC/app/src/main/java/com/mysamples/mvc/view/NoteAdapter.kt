package com.mysamples.mvc.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mysamples.mvc.R
import com.mysamples.mvc.model.domain.Note

class NoteAdapter :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    val list: MutableList<Note> =
        arrayListOf(
            Note(id = 1, title = "test"),
            Note(id = 2, title = "test"),
            Note(id = 3, title = "test"),
            Note(id = 4, title = "test"),
            Note(id = 5, title = "test"),
            Note(id = 6, title = "test"),
            Note(id = 7, title = "test"),
        )

    fun setData(items: List<Note>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.itemNameTextView.text = item.title
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
    }
}
