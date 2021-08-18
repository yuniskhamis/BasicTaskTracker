package com.yunis.basictasktracker

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

// 1. Define Adapter class
// 2. Implement RecyclerView Adapter
// 3. Created ViewHolder
// 4. Created stubs for our implement methods

// Bridge the layout file and our data
@Suppress("DEPRECATION", "UnusedEquals")
class RecyclerViewAdapter(private val listOfItems: MutableList<Any>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    // Specify which layout to use for each item inside the recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val items = inflater.inflate(R.layout.item_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(items)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listOfItems[position]
        holder.textView.text = item.toString()


    }

    // Tells RecyclerView how many items it needs to lay out
    override fun getItemCount(): Int {
        return listOfItems.size
    }

    // Make layout more efficient
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView


        init {
            textView = itemView.findViewById(R.id.textView)

            textView.setOnLongClickListener {
                removeItem(position)
                false
            }


        }

    }

    fun removeItem(position: Int) {
        listOfItems.remove(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, listOfItems.size)
    }


}


