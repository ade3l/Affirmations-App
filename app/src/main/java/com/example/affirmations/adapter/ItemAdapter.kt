package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

class ItemAdapter (private val context: Context, private val dataset:List<Affirmation>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    /*The onCreateViewHolder()method is called by the layout manager to create new view holders for the RecyclerView
    (when there are no existing view holders that can be reused).*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        /*parent is the view group that the new list item view will be attached to as a child.
         The parent is the RecyclerView.*/
        //Third argument needs to be false, because RecyclerView adds this item to the view hierarchy for you when it's time.
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
//      Now adapterLayout holds a reference to the list item view
        return ItemViewHolder(adapterLayout)
    }

//    This method is called by the layout manager in order to replace the contents of a list item view.
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
      /*Two parameters:
        an ItemViewHolder previously created by the onCreateViewHolder() method,
        and an int that represents the current item position in the list.*/
        val item=dataset[position]
        holder.textView.text=context.resources.getString(item.stringResourceId)
    }

    override fun getItemCount()=dataset.size
}