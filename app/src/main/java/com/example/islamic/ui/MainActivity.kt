package com.example.islamic.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islamic.R
import com.example.islamic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        initviews()

    }

    private fun initviews() {
        navigateToFragments()

    }

    private fun navigateToFragments() {
        viewBinding.bottomNavigationViews.setOnItemSelectedListener {
            if (it.itemId == R.id.Qurran){
                navigateTo(SurahFragment())
            }
            else if (it.itemId == R.id.Hadeeth){
                navigateTo(HadithFragment())
            }
            else if (it.itemId == R.id.Taspeeh){
                navigateTo(TaspeehFragment())
            }
            else if (it.itemId == R.id.Radio){
                navigateTo(RadioFragment())
            }
// QQQQQQQQ
            return@setOnItemSelectedListener true
        }
    }


    override fun onStart() {
        super.onStart()
        navigateTo(SurahFragment())
    }

    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_Fragment, fragment)
            .commit()

    }
}