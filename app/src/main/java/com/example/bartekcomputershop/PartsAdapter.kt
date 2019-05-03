package com.example.bartekcomputershop

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.bartekcomputershop.models.Part
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.part_row.view.*

class PartsAdapter(private val parts: List<Part>) : androidx.recyclerview.widget.RecyclerView.Adapter<PartsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: PartsAdapter.ViewHolder, position: Int) {
        val part = parts[position]
        Picasso.get().load(part.photoUrl).into(holder.image)
        holder.title.text = part.title
        holder.price.text = part.price.toString()

        if (part.isOnSale) {
            holder.isOnSale.visibility = View.VISIBLE
        } else {
            holder.isOnSale.visibility = View.GONE

        }

    }

    override fun onCreateViewHolder   (parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.part_row, parent, false)
        val holder = ViewHolder(view)
        view.setOnClickListener {
            val intent = Intent(parent.context, PartDetails::class.java)
            intent.putExtra("title", parts[holder.adapterPosition].title)
            intent.putExtra("photo_url", parts[holder.adapterPosition].photoUrl)
            parent.context.startActivity(intent)
        }
        return holder

    }

    override fun getItemCount() = parts.size



    class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.photo)
        val title: TextView = itemView.findViewById(R.id.title)
        val price: TextView = itemView.findViewById(R.id.price)
        val isOnSale = itemView.saleImage

    }

}