package com.example.uts_pagisore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_pagisore.R

class MembershipAdapter(private val memberships: List<Membership>) :
    RecyclerView.Adapter<MembershipAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewLogo: ImageView = view.findViewById(R.id.imageViewLogo)
        val textViewName: TextView = view.findViewById(R.id.textViewName)
        val textViewDate: TextView = view.findViewById(R.id.textViewDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_membership, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val membership = memberships[position]
        holder.imageViewLogo.setImageResource(membership.logoResId)
        holder.textViewName.text = membership.name
        holder.textViewDate.text = membership.date
    }

    override fun getItemCount() = memberships.size
}

data class Membership(val name: String, val date: String, val logoResId: Int)