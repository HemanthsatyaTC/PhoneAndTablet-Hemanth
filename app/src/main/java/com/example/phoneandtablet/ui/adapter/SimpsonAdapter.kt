package com.example.phoneandtablet.ui.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.phoneandtablet.R
import com.example.phoneandtablet.data.model.simpson.RelatedTopicModel
import com.example.phoneandtablet.databinding.SimpsonDetailsBinding
import com.example.phoneandtablet.ui.additional.AdditionalFragment

class SimpsonAdapter(
    private var simpsons: List<RelatedTopicModel?>?
) : RecyclerView.Adapter<SimpsonAdapter.MyViewHolder>(), Filterable {

    private var filteredSimpsons: List<RelatedTopicModel?>? = simpsons

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = SimpsonDetailsBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.simpson_details, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = filteredSimpsons?.get(position)
        holder.binding.apply {
            val nameText = currentUser?.text?.split(" - ")?.get(0)
            val fullText = currentUser?.text?.split(" - ")?.get(1)
            val img = currentUser?.icon?.uRL
            name.text = nameText ?: "Unknown"
            details.text = fullText ?: "No details available"
            details.text = fullText ?: "No details available"
            Glide.with(holder.itemView.context)
                .load(img)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView)

        }
    }

    override fun getItemCount(): Int {
        return simpsons?.size ?: 1
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint?.toString()?.lowercase() ?: ""

                val filteredList = if (query.isEmpty()) {
                    simpsons
                } else {
                    simpsons?.filter {
                        it?.text?.split(" - ")?.get(0)?.lowercase()?.contains(query) ?: false
                    }
                }

                val results = FilterResults()
                results.values = filteredList
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredSimpsons = results?.values as? List<RelatedTopicModel?>
                notifyDataSetChanged()
            }

        }
    }
}
