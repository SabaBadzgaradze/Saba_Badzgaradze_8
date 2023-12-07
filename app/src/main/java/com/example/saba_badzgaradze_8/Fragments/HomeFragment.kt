package com.example.saba_badzgaradze_8.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.saba_badzgaradze_8.R
import com.example.saba_badzgaradze_8.SecondActivity

class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var button: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button = view.findViewById(R.id.button)

        button.setOnClickListener {
            val intent = Intent(activity,SecondActivity::class.java)
            startActivity(intent)
        }

    }
}