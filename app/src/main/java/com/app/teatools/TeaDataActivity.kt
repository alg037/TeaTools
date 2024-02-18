package com.app.teatools


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TeaDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tea_data)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title="茶叶数据"
            setDisplayShowTitleEnabled(false)
        }
        findViewById<Button>(R.id.tea_data_add).setOnClickListener {
            val intent = Intent(this,TeaDataModifyActivity::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.tea_data_recycler_tea)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = listOf(
            Item("Item 1",R.drawable.tea),
            Item("Item 2",R.drawable.tea),
            Item("Item 3",R.drawable.tea),
            Item("Item 4",R.drawable.tea),
            Item("Item 5",R.drawable.tea),
            Item("Item 6",R.drawable.tea),
            Item("Item 7",R.drawable.tea),
            Item("Item 8",R.drawable.tea),


            ) // 模拟数据

        val adapter = MyAdapter(data)
        recyclerView.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tea_data_toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.backup -> Toast.makeText(this,"back",Toast.LENGTH_LONG).show()
            R.id.delete -> Toast.makeText(this,"delete",Toast.LENGTH_LONG).show()
            R.id.settings -> Toast.makeText(this,"settings",Toast.LENGTH_LONG).show()
        }
    return true
    }
    data class Item(val name:String,val imageResId:Int)
    class MyAdapter(private val data: List<Item>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.tea_data_layout, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = data[position]
            holder.bind(item)
        }

        override fun getItemCount(): Int {
            return data.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val image :ImageView = itemView.findViewById(R.id.tea_data_item_tea_img)
            private val info : TextView = itemView.findViewById(R.id.tea_data_item_tea_info)
//            private val btn_modify:Button = itemView.findViewById(R.id.tea_data_item_tea_modify)
//            init {
//                btn_modify.setOnClickListener {
//                    val position = adapterPosition
//                    if (position != RecyclerView.NO_POSITION){
//                        data.toMutableList().removeAt(position)
//                    }
//                }
//            }

            fun bind(item: Item) {
                image.setImageResource(item.imageResId)
                info.text = item.name
            }
        }
    }


}