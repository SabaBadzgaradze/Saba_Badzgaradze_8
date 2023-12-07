package com.example.saba_badzgaradze_8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    private lateinit var backBtn: ImageView
    private lateinit var addBtn: Button
    private lateinit var name: EditText
    private lateinit var phone: EditText
    private lateinit var db: SQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        backBtn = findViewById(R.id.backBtn)
        addBtn = findViewById(R.id.addBtn)
        name = findViewById(R.id.nameEdt)
        phone = findViewById(R.id.phoneEdt)
        db = SQLiteHelper(this)


        addBtn.setOnClickListener {
            val names = name.text.toString()
            val numbers = phone.text.toString()
            val saveData = db.saveUserData(names, numbers)
            if (TextUtils.isEmpty(names) || TextUtils.isEmpty(numbers)){
                Toast.makeText(this, "Add Name & Phone Number", Toast.LENGTH_SHORT).show()
            }
            else {
                if (saveData == true){
                    Toast.makeText(this, "Save Contact", Toast.LENGTH_SHORT).show()
                } else{
                    Toast.makeText(this, "Exist Contact", Toast.LENGTH_SHORT).show()
                }
            }
        }


        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}