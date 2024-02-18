package com.app.teatools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class TeaProcessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tea_process)


        val ed_worker_id = findViewById<EditText>(R.id.tea_process_edit_worker)
        ed_worker_id.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus){
                ed_worker_id.setText("")
            }
        }
        ed_worker_id.addTextChangedListener (object :TextWatcher{
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val worker_id: String = s.toString();
                val  v1 = findViewById<EditText>(R.id.tea_process_edit_tea_name)
                v1.setText(worker_id)
                Toast.makeText(this@TeaProcessActivity,"接收到扫描字符:"+v1.text, Toast.LENGTH_LONG).show()
                if (worker_id.endsWith("\n")) {
                    //Toast.makeText(this@TeaProcessActivity,"接收到扫描字符:$worker_id", Toast.LENGTH_LONG).show()
                    //}
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

    }
    }