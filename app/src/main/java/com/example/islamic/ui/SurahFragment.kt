package com.example.islamic.ui

import android.content.Intent
import android.icu.text.Transliterator.Position
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamic.OnItemClick
import com.example.islamic.R
import com.example.islamic.adapters.SurahAdapter
import com.example.islamic.constants.SurahData
import com.example.islamic.constants.surahNames
import com.example.islamic.databinding.FragmentSurahBinding


class SurahFragment : Fragment() {

    lateinit var surahAdapter: SurahAdapter
    lateinit var viewBinding : FragmentSurahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = FragmentSurahBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSurahBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
    surahAdapter=   SurahAdapter(surahNames.ArSuras.mapIndexed {position , name ->
        SurahData(position+1, name)
    })
        viewBinding.RVSurahList.adapter=surahAdapter
        surahAdapter.onItemClick= object :OnItemClick{
            override fun onItemClickListner(surahData: SurahData) {
                val intent = Intent(requireActivity(), SurahDetailsActivity::class.java)
                intent.putExtra("surah_name", surahData.surahName)
                intent.putExtra("surah_number", surahData.surahNumber)
                startActivity(intent)
            }
        }

    }


}