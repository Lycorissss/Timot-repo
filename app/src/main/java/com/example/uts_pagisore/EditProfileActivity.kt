package com.example.uts_pagisore

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class EditProfileActivity : Fragment(R.layout.activity_edit_profile) {

    private lateinit var saveButton: Button
    private lateinit var cancelButton: Button
    private lateinit var editSurname: EditText
    private lateinit var editName: EditText
    private lateinit var editDOB: EditText
    private lateinit var editPhoneNumber: EditText
    private lateinit var editEmail: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi komponen
        saveButton = view.findViewById(R.id.buttonSave)
        cancelButton = view.findViewById(R.id.buttonCancel)
        editSurname = view.findViewById(R.id.editSurname)
        editName = view.findViewById(R.id.editName)
        editDOB = view.findViewById(R.id.editDOB)
        editPhoneNumber = view.findViewById(R.id.editPhoneNumber)
        editEmail = view.findViewById(R.id.editEmail)

        // Tombol Save
        saveButton.setOnClickListener {
            // Implementasikan logika penyimpanan perubahan profil
            saveProfileChanges()
        }

        // Tombol Cancel
        cancelButton.setOnClickListener {
            // Kembali ke fragment profil tanpa menyimpan
            findNavController().navigateUp()
        }
    }

    private fun saveProfileChanges() {
        // Implementasikan logika untuk menyimpan perubahan profil
        val newSurname = editSurname.text.toString()
        val newName = editName.text.toString()
        val newDOB = editDOB.text.toString()
        val newPhoneNumber = editPhoneNumber.text.toString()
        val newEmail = editEmail.text.toString()

        // Simpan perubahan ke database atau shared preferences, tergantung arsitektur aplikasi Anda
    }
}