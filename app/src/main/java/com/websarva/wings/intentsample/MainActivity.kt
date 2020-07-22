package com.websarva.wings.intentsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)

        val menuList: MutableList<MutableMap<String,String>> = mutableListOf()

        var menu = mutableMapOf<String,String>("name" to "から揚げ定食" , "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf<String,String>("name" to "焼肉定食" , "price" to "900円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "生姜焼き定食", "price" to "850円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ステーキ定食", "price" to "1000円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "野菜炒め定食", "price" to "750円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "とんかつ定食", "price" to "900円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ミンチかつ定食", "price" to "850円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "チキンカツ定食", "price" to "900円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "コロッケ定食", "price" to "850円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "焼き魚定食", "price" to "850円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "焼肉定食", "price" to "950円")
        menuList.add(menu)

        val from = arrayOf("name", "price")

        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        val adapter = SimpleAdapter(applicationContext,
            menuList, android.R.layout.simple_list_item_2, from, to)

        lvMenu.adapter = adapter

        lvMenu.onItemClickListener = ListItemClickListener()
    }

    private inner class ListItemClickListener: AdapterView.OnItemClickListener {
        override fun onItemClick(p0: AdapterView<*>, p1: View?, p2: Int, p3: Long) {
            val item = p0.getItemAtPosition(p2) as MutableMap<String,String>

            val menuName = item["name"]
            val menuPrice = item["price"]

            val intent = Intent(applicationContext, MenuThanksActivity::class.java)

            intent.putExtra("menuName", menuName)
            intent.putExtra("price", menuPrice)

            startActivity(intent)
        }
    }
}