package com.example.onetohundredrecycler

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onetohundredrecycler.models.NumberData
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<NumberData> = ArrayList()
    override fun getItemViewType(position: Int): Int = position

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return NumberViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NumberViewHolder -> {
                holder.bind(items[position])
                holder.getItemViewType()
                holder.itemView.isEnabled = true
            }
        }
        holder.setIsRecyclable(false) //adding this and below line for testing app
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
        private val plusButton: Button = itemView.plus_button
        private val minusButton: Button = itemView.minus_button


        fun bind(numData: NumberData) {
            numDisplay.text = (numData.number).toString()
            plusButton.setOnClickListener {
                val newNumber = numDisplay.text.toString().toInt() + 1
                if (newNumber != 101) {
                    numDisplay.text = newNumber.toString()
                    numData.number = newNumber
                }
                Log.d("new_number", newNumber.toString())
            }
            minusButton.setOnClickListener {
                val newNumberMinus = numDisplay.text.toString().toInt() - 1
                if (newNumberMinus != 0) {
                    numDisplay.text = newNumberMinus.toString()
                    numData.number = newNumberMinus
                }

            }

        }

    }
}