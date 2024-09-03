package com.example.app_tablet.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_tablet.R
import com.example.app_tablet.data.model.wire.RelatedTopicModelWire
import com.example.app_tablet.databinding.WireDetailsBinding

class WireAdapter(
    private val wire: RelatedTopicModelWire
): RecyclerView.Adapter<WireAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = WireDetailsBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.wire_details, parent, false)
        return MyViewHolder(view)
    }


    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = wire
        holder.binding.apply{
            name.text = currentUser.toString()

        }
    }

    override fun getItemCount(): Int {
        return 1
    }

}
