package com.example.saba_badzgaradze_8

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.fragment.app.FragmentActivity

class SQLiteHelper(context: FragmentActivity?): SQLiteOpenHelper(context,"USERDATA",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERDATA (name TEXT PRIMARY KEY, contact TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS USERDATA")
    }

    fun saveUserData(name: String, contact: String): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("name", name)
        cv.put("contact", contact)
        val result = db.insert("USERDATA", null,cv)
        if (result == (-1).toLong()){
            return false
        }
        return true
    }

    fun getText(): Cursor? {
        val db = this.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM USERDATA",null)
        return cursor
    }


}