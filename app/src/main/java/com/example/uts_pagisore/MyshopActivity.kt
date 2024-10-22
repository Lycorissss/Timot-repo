package com.example.uts_pagisore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton

class MyshopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myshop)

        // Penanganan tombol kembali
        findViewById<ImageButton>(R.id.buttonBack).setOnClickListener {
            finish() // Menutup aktivitas dan kembali ke aktivitas sebelumnya
        }

        // Penanganan tombol edit
        findViewById<ImageButton>(R.id.buttonEditShop).setOnClickListener { view ->
            onSomeButtonClick(view)
        }

        // Penanganan tombol edit config
        findViewById<ImageButton>(R.id.buttonEditConfig).setOnClickListener { view ->
            // Logika edit config
        }
    }

    // Jika Anda ingin menangani click event atau logika lain
    fun onSomeButtonClick(view: View) {
        // Logika yang ingin diimplementasikan saat tombol diklik
    }
}
