package com.example.project2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var wishAdapter: WishAdapter
    private val wishList = mutableListOf<WishItem>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val submitButton: Button = findViewById(R.id.submitButton)
        val wishEditText: EditText = findViewById(R.id.wishEditText)

        wishAdapter = WishAdapter(wishList)
        recyclerView.adapter = wishAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        submitButton.setOnClickListener {
            val wishText = wishEditText.text.toString()
            if (wishText.isNotEmpty()) {
                wishList.add(WishItem(wishText))
                wishAdapter.notifyItemInserted(wishList.size - 1)
                wishEditText.text.clear()
            }
        }
    }
}
