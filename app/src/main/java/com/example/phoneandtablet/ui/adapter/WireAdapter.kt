package com.example.phoneandtablet.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phoneandtablet.R
import com.example.phoneandtablet.data.model.wire.RelatedTopicModelWire
import com.example.phoneandtablet.databinding.WireDetailsBinding

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
//            lastName.text = currentUser.lastName
//            idnumber.text = currentUser.id
//            email.text = currentUser.email
//            Glide.with(holder.itemView.context)
//                .load(currentUser.avatar)
//                .placeholder(R.drawable.ic_launcher_background)
//                .into(imageView)

//            viewMoreDetails.setOnClickListener(View.OnClickListener {
//
//                val context = holder.itemView.context
//                val intent = Intent(context, BlankFragment::class.java)
//                intent.putExtra("id", currentUser.id)
//                intent.putExtra("title", currentUser.jobtitle)
//                intent.putExtra("color", currentUser.favouriteColor)
//                intent.putExtra("date", currentUser.createdAt)
//
//
//                context.startActivity(intent)
////                mediaPlayer.startMusic()
//            })


        }
    }

    override fun getItemCount(): Int {
        return 1
    }

}
