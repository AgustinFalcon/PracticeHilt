package com.example.playwithhiltagus.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.playwithhiltagus.R
import com.example.playwithhiltagus.dataclasses.RecyclerData
import kotlinx.android.synthetic.main.item_recyclerview.view.*

class RecyclerViewAdapter(): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {


    private var listData: List<RecyclerData>? = null

    //add elements to list
    fun setListData(listData: List<RecyclerData>?){
        this.listData = listData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int{
        if (listData == null) return 0  //if is null return nothing
        return listData?.size!!         //if listData have someone element return the list
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) { //Capture the filds and paint the same
        val thumbImage = view.thumbImage
        val tvName = view.tvName
        val tvDesc = view.tvDesc

        fun bind(data: RecyclerData){
            tvName.text = data.name
            tvDesc.text = data.description
            Glide.with(thumbImage).load(data.owner?.avatar_url).into(thumbImage)
        }
    }
}