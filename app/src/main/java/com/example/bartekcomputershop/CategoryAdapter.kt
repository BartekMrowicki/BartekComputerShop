package com.example.bartekcomputershop

import androidx.recyclerview.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.cat_row.view.*

class CategoryAdapter(val categories: List<String>) : androidx.recyclerview.widget.RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
   holder.catName.text = categories[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int): ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = categories.size

    class ViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
    val catName = view.catName  }

}
