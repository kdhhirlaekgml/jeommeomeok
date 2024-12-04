package com.example.lunchpicker

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var etMenuItem: EditText
    private lateinit var btnAddMenu: Button
    private lateinit var lvMenu: ListView

    private val menuList: MutableList<String> = mutableListOf("김치찌개", "된장찌개", "피자", "치킨")
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        etMenuItem = findViewById(R.id.etMenuItem)
        btnAddMenu = findViewById(R.id.btnAddMenu)
        lvMenu = findViewById(R.id.lvMenu)

        // 리스트뷰 어댑터 설정
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, menuList)
        lvMenu.adapter = adapter

        // 메뉴 추가
        btnAddMenu.setOnClickListener {
            val newItem = etMenuItem.text.toString()
            if (newItem.isNotBlank()) {
                menuList.add(newItem)
                adapter.notifyDataSetChanged()
                etMenuItem.text.clear()
            } else {
                Toast.makeText(this, "메뉴를 입력해주세요!", Toast.LENGTH_SHORT).show()
            }
        }

        // 메뉴 삭제
        lvMenu.setOnItemClickListener { _, _, position, _ ->
            menuList.removeAt(position)
            adapter.notifyDataSetChanged()
        }
    }
}
