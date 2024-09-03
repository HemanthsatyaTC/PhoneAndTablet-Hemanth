package com.example.app_tablet.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_tablet.R
import com.example.app_tablet.data.model.simpson.RelatedTopicModel
import com.example.app_tablet.databinding.SimpsonDetailsBinding

class SimpsonAdapter(
    private val simpsons: RelatedTopicModel
): RecyclerView.Adapter<SimpsonAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = SimpsonDetailsBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.simpson_details, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 1
    }


    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = simpsons
        holder.binding.apply {
            name.text = currentUser.toString()


        }
    }
}