package com.example.onetohundredrecycler

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onetohundredrecycler.models.NumberData
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<NumberData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NumberViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NumberViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(numList: List<NumberData>) {
        items = numList
        Log.d("list0", items.toString())
    }


    class NumberViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val numDisplay: TextView = itemView.text


        fun bind(numData: NumberData) {
            numDisplay.text = (numData.number).toString()
        }
    }
}