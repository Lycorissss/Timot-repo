package com.example.uts_pagisore

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var editProfileButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi tombol Edit Profile
        editProfileButton = view.findViewById(R.id.buttonEditProfile)

        // Set onClick listener untuk Edit Profile Button
        editProfileButton.setOnClickListener {
            // Menggunakan NavController untuk navigasi ke EditProfileFragment
            try {
                findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
