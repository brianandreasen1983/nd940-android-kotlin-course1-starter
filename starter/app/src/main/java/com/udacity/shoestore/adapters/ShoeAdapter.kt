package com.udacity.shoestore.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

// Adapter used for the recycler view in the shoe_listing_fragment.
class ShoeAdapter : RecyclerView.Adapter<TextItemViewHolder>() {
    var data = listOf<Shoe>()
    set(value) {
        field = value
        // tells recyclerview that the whole dataset may has changed and needs to re-render.
        notifyDataSetChanged()
    }

    // Must return the total number of items held in the adapter.
    override fun getItemCount() = data.size

    // This is where the data is passed and assigned to whatever is in the view holder
    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        // data is destroyed for some reason when we get here after notifying the data set has changed after adding a shoe.
        val item = data[position]
        holder.textView.text = item.name
    }

    // Responsible for inflating the layout, creating the view holder, and returning a view.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }
}