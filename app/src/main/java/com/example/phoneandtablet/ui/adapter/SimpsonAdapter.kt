package com.example.phoneandtablet.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phoneandtablet.R
import com.example.phoneandtablet.data.model.simpson.RelatedTopicModel
import com.example.phoneandtablet.databinding.SimpsonDetailsBinding

class SimpsonAdapter(
    private val simpsons: List<RelatedTopicModel?>?
): RecyclerView.Adapter<SimpsonAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = SimpsonDetailsBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.simpson_details, parent, false)
        return MyViewHolder(view)
    }


    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = simpsons?.get(position)
        holder.binding.apply{
            name.text = currentUser?.text

//            if (currentUser != null) {
//                for (topic in currentUser){
//                        val text = topic?.text
//                        name.text = text
//                }
//            }
//            name.text = currentUser.relatedTopics.toString()
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
        return simpsons?.size ?: 1
    }

}
