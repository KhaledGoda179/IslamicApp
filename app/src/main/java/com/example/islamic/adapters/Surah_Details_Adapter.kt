package com.example.islamic.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic.databinding.SurahVersesBinding

class Surah_Details_Adapter(var list: List<String?>?):RecyclerView.Adapter<Surah_Details_Adapter.MyViewHolder>() {
    class MyViewHolder(val surahLayout: SurahVersesBinding): RecyclerView.ViewHolder(surahLayout.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = SurahVersesBinding.inflate(LayoutInflater.from(parent.context), parent, false )
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = list!!.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list!![position]
        holder.surahLayout.TVSurahVerses.text = item
    }

    fun updateData(data: List<String>) {
        this.list= data
        notifyDataSetChanged()
    }
}