package com.example.prod_playground.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prod_playground.R
import com.example.prod_playground.databinding.ActivityMainBinding
import com.example.prod_playground.ui.specialOffers.SpecialOffersFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragment = SpecialOffersFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit()
        }
    }
}
