package com.example.onetohundredrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onetohundredrecycler.models.NumberData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var numAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()
    }

    private fun createDataSet(): ArrayList<NumberData> {
        val list = ArrayList<NumberData>()
        for (i in 1..100) {
            list.add(NumberData(i))
        }
        Log.d("list_for_loop_data", list.toString())
        return list
    }

    private fun createDataSet2(): IntArray {
        val numbers = IntArray(100) { (it + 1) }
        Log.d("numbers", numbers.toString())
        return numbers
    }

    private fun addDataSet() {
        val data = createDataSet()
        Log.d("data_watch", data.toString())
        numAdapter.submitList(data)
//        val data2 = createDataSet2()
//        numAdapter.submitList2(data2)
    }

    private fun initRecyclerView() {
        recycler_view.apply {
            recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
            numAdapter = RecyclerAdapter()
            recycler_view.adapter = numAdapter
        }
    }

}