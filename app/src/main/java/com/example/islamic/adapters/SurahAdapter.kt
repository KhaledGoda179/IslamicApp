package com.example.islamic.adapters

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic.OnItemClick
import com.example.islamic.constants.SurahData

import com.example.islamic.databinding.SurahListItemBinding

class SurahAdapter(val list: List<SurahData>) :RecyclerView.Adapter<SurahAdapter.MyViewHolder>(){

    var onItemClick: OnItemClick?= null
    class MyViewHolder(val viewBinding: SurahListItemBinding):
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = SurahListItemBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = list.size ?: 0

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val surah =list[position]
        holder.viewBinding.TVSurahNumber.text = surah.surahNumber.toString()
        holder.viewBinding.TVSurahName.text = surah.surahName
        holder.itemView.setOnClickListener {
            onItemClick?.onItemClickListner(surah)
        }
    }
}