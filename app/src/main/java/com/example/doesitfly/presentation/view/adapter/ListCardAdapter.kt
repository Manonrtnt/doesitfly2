package com.example.doesitfly.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doesitfly.beans.FlyingSiteBean
import com.example.doesitfly.databinding.ListCardDetailBinding

class ListCardAdapter(
    private var flyingSiteList: List<FlyingSiteBean?>?
)
    : RecyclerView.Adapter<ListCardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ListCardDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val flyingSite = flyingSiteList?.get(position)
        holder.bind(flyingSite)
    }

    override fun getItemCount(): Int {
        return flyingSiteList?.size ?: 0
    }

    fun updateData(newData: List<FlyingSiteBean?>?) {
        flyingSiteList = newData
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ListCardDetailBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(flyingSite: FlyingSiteBean?) {
            // Bind data to view
            binding.textViewSiteName.text = flyingSite?.nom ?: ""
            binding.textViewCity.text = (flyingSite?.cp + "" + flyingSite?.ville)
            binding.textViewWind.text = flyingSite?.vent_favo ?: ""
        }
    }

//    @SuppressLint("SetTextI18n")
//    override fun onBindViewHolder(holder: ListCardViewHolder, position: Int) {
//
//        val item = flyingSiteList[position]
//
//        holder.siteNameTextView.text = item?.nom
//        holder.cityTextView.text = item?.ville + " " + item?.cp
//        holder.windTextView.text = item?.ventFavo
//    }
//
//    override fun getItemCount(): Int {
//        return flyingSiteList.size
//    }

//    class ListCardViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView){
//        val siteNameTextView : TextView = itemView.findViewById(R.id.textViewSiteName)
//        val cityTextView : TextView = itemView.findViewById(R.id.textViewCity)
//        val windTextView : TextView = itemView.findViewById(R.id.textViewWind)
//    }
}