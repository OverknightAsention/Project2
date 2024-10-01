package com.example.project2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WishlistAdapter
    private val wishlistItems = mutableListOf<WishlistItem>()

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.Recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = WishlistAdapter(wishlistItems)
        recyclerView.adapter = adapter

        val addButton: Button = findViewById(R.id.addbutton)
        val nameInput: EditText = findViewById(R.id.nameinput)
        val descriptionInput: EditText = findViewById(R.id.description_input)

        addButton.setOnClickListener {
            val name = nameInput.text.toString()
            val description = descriptionInput.text.toString()
            if (name.isNotEmpty() && description.isNotEmpty()) {
                val newItem = WishlistItem(name, description)
                wishlistItems.add(newItem)
                adapter.notifyItemInserted(wishlistItems.size - 1)
                nameInput.text.clear()
                descriptionInput.text.clear()
            }
        }

        // Add user input handling here
    }
}
