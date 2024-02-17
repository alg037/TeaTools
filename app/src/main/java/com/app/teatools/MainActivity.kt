package com.app.teatools

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.main_btn_tea_data).setOnClickListener{
            val intent = Intent(this,TeaDataActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.main_btn_worker_data).setOnClickListener{
            val intent = Intent(this,WorkerDataActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.main_btn_tea_process).setOnClickListener{
            val intent = Intent(this,TeaProcessActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.main_btn_tea_inquire).setOnClickListener{
            val intent = Intent(this,TeaInquireActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.main_btn_sysytem_setting).setOnClickListener{
            val intent = Intent(this,SystemSettingActivity::class.java)
            startActivity(intent)
        }
    }
}