package com.example.islamic.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamic.R
import com.example.islamic.adapters.Surah_Details_Adapter
import com.example.islamic.databinding.ActivitySurahDetailsBinding

class SurahDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySurahDetailsBinding
    var surahName: String? = null
    var surahPosition: Int? = 0
    lateinit var adapter: Surah_Details_Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivitySurahDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        initViews()
    }

    private fun initViews() {
        surahName= intent.getStringExtra("surah_name")
        surahPosition= intent.getIntExtra("surah_number",1)
        adapter = Surah_Details_Adapter(null)
        readDataFromFile()
        viewBinding.RVSurah.adapter= adapter
        viewBinding.TVSurahAdrees.text= surahName
    }

    fun readDataFromFile() {
        val fileContent = assets.open("$surahPosition.txt").bufferedReader().use {
            it.readText()
        }
        val data = fileContent.split("\n")
        adapter.updateData(data)
    }
}
