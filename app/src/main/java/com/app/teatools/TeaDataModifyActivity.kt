package com.app.teatools

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TeaDataModifyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tea_data_modify)

        findViewById<Button>(R.id.tea_data_modify_save).setOnClickListener {
            val intent = Intent(this,TeaDataActivity::class.java)
            startActivity(intent)
        }
    }
}