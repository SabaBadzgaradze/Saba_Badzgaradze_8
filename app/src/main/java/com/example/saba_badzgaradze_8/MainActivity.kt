package com.example.saba_badzgaradze_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.saba_badzgaradze_8.Adapter.MyViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        val myViewPagerAdapter = MyViewPagerAdapter(this)

        viewPager2.adapter = myViewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            if (position == 0 ){
                tab.text = "Home"
            } else {
                tab.text = "Profile"
            }

        }.attach()



    }
}