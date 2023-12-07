package com.example.saba_badzgaradze_8.Adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.saba_badzgaradze_8.Fragments.HomeFragment
import com.example.saba_badzgaradze_8.Fragments.ProfileFragment

class MyViewPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if(position == 0){
            HomeFragment()
        } else {
            ProfileFragment()
        }
    }
}