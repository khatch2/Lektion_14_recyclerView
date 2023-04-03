package com.example.lektion_14_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CustomAdapter
    private var scoreList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.rv_scores)   // ID
        val layoutManager = LinearLayoutManager(applicationContext)     // Constraint?

        adapter = CustomAdapter(scoreList)              // Define adapter

        recyclerView.layoutManager = layoutManager      // Pick Layout for Recycler
        recyclerView.adapter = adapter                  // Pick adapter for Recycler

        prepareItems()

        // onItemClick
        adapter.onItemClick = {
            Toast.makeText(applicationContext, "Score was: $it", Toast.LENGTH_LONG).show()
        }
    }

    private fun prepareItems() {

        for (i in 1..1000) {
            scoreList.add("Some new random story was happening and it kept repeating, Some new random story was happening and it kept repeating, Some new random story was happening and it kept repeating, Some new random story was happening and it kept repeating, Some new random story was happening and it kept repeating,  Score: ${i * 9 / 4 + 1} ")
        }

        // Always Notify On Change / Insert
        adapter.notifyItemRangeInserted(1, 1000)
    }

}
