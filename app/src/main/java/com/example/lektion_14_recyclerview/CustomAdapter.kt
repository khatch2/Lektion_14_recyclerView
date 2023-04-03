package com.example.lektion_14_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class CustomAdapter(
    private var itemsList: List<String>
    ): RecyclerView.Adapter<CustomAdapter.MyViewHolder>()
{

    var onItemClick: ((String) -> Unit)? = null     // BoilerPLate

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.tv_score)
        // Have more TextViews? Define them here!

        // Define OnCLick
        init {
            view.setOnClickListener {
                onItemClick?.invoke(itemsList[adapterPosition])
            }
        }

    }

    // onCreate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_score, parent, false)

        return MyViewHolder(itemView)
    }

    // Size
    override fun getItemCount(): Int {
        return itemsList.size
    }

    // Define item_score
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemTextView.text = item



    }

}












