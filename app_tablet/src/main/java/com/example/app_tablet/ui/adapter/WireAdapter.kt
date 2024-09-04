package com.example.app_tablet.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app_tablet.R
import com.example.app_tablet.data.model.wire.RelatedTopicModelWire
import com.example.app_tablet.databinding.WireDetailsBinding

class WireAdapter(
    private val wire: List<RelatedTopicModelWire?>?
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
        val currentUser = wire?.get(position)
        holder.binding.apply{
            val nameText = currentUser?.text?.split(" - ")?.get(0)
            val fullText = currentUser?.text?.split(" - ")?.get(1)
            val img = currentUser?.icon?.uRL

            name.text = nameText
            details.text = fullText
            Glide.with(holder.itemView.context)
                .load(img)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView)

        }
    }

    override fun getItemCount(): Int {
        return wire?.size?:1
    }

}
