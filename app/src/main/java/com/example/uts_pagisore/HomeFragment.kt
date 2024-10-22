package com.example.uts_pagisore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MembershipAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewMemberships)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val buttonMyShop: LinearLayout = view.findViewById(R.id.buttonMyShop)

        buttonMyShop.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_myShopActivity)
        }

        val memberships = listOf(
            Membership("FAZ CAFE & BALLS", "2022/08/13", R.drawable.logo_faz_cafe),
            Membership("Syahri's Wash", "2022/07/23", R.drawable.logo_syahris_wash),
            Membership("Frost Gaming x Pool", "2022/07/13", R.drawable.logo_frost_gaming)
        )

        adapter = MembershipAdapter(memberships)
        recyclerView.adapter = adapter

    }
}
