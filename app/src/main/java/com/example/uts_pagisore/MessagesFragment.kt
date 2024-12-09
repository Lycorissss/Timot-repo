package com.example.uts_pagisore

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uts_pagisore.Message.Message
import com.example.uts_pagisore.Message.MessagesAdapter
import com.example.uts_pagisore.Message.MessagesDetail
import com.example.uts_pagisore.databinding.FragmentMessagesBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*
import android.util.Log

class MessagesFragment : Fragment() {

    private var _binding: FragmentMessagesBinding? = null
    private val binding get() = _binding!!
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMessagesBinding.inflate(inflater, container, false)
        val view = binding.root

        // Setup RecyclerView
        binding.rvMessageList.layoutManager = LinearLayoutManager(requireContext())

        // Fetch messages from Firestore and set up the adapter
        fetchMessages()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fetchMessages() {
        db.collection("Announcement")
            .get()
            .addOnSuccessListener { result ->
                val messages = mutableListOf<Message>()

                // Menambahkan log untuk memastikan data diambil
                Log.d("FirestoreCheck", "Data successfully fetched from Firestore")

                for (document in result) {
                    val title = document.getString("title") ?: "No Title"
                    val description = document.getString("description") ?: "No Description"
                    val time = document.getLong("time")?.let {
                        // Convert timestamp to readable date
                        val sdf = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
                        sdf.format(Date(it))
                    } ?: "No Time"

                    // Menambahkan log untuk setiap dokumen yang diambil
                    Log.d("FirestoreCheck", "Fetched Document: Title: $title, Description: $description, Time: $time")

                    // Add the fetched message to the list
                    messages.add(Message(title, description, time))
                }

                // Menambahkan log setelah semua data dimasukkan ke dalam adapter
                Log.d("FirestoreCheck", "Total Messages: ${messages.size}")

                // Set up the adapter with the fetched messages
                binding.rvMessageList.adapter = MessagesAdapter(messages) { message ->
                    val intent = Intent(requireContext(), MessagesDetail::class.java).apply {
                        putExtra("MESSAGE_TITLE", message.title)
                        putExtra("MESSAGE_DESCRIPTION", message.description)
                        putExtra("MESSAGE_TIME", message.time)
                        putExtra("MESSAGE_CONTENT", "Detailed content for ${message.title}")
                        putExtra("MESSAGE_ICON", R.drawable.bird_icon)
                    }
                    startActivity(intent)
                }
            }
            .addOnFailureListener { e ->
                // Log error if fetching fails
                Log.e("FirestoreCheck", "Error fetching messages: ${e.message}")
                Toast.makeText(requireContext(), "Error fetching messages: ${e.message}", Toast.LENGTH_SHORT).show()
            }

    }
}
