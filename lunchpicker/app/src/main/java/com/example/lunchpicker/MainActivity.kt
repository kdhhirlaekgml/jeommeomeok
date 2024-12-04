package com.example.lunchpicker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var btnSpin: Button
    private lateinit var btnSearch: Button
    private lateinit var btnSettings: Button

    private var menuList: MutableList<String> = mutableListOf("김치찌개", "된장찌개", "피자", "치킨")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
        btnSpin = findViewById(R.id.btnSpin)
        btnSearch = findViewById(R.id.btnSearch)
        btnSettings = findViewById(R.id.btnSettings)

        // 룰렛 돌리기
        btnSpin.setOnClickListener {
            if (menuList.isNotEmpty()) {
                val randomIndex = Random.nextInt(menuList.size)
                val selectedMenu = menuList[randomIndex]
                tvResult.text = selectedMenu
                btnSearch.visibility = Button.VISIBLE
            } else {
                tvResult.text = "메뉴를 추가해주세요!"
            }
        }

        // 네이버 검색
        btnSearch.setOnClickListener {
            val query = tvResult.text.toString()
            val url = "https://m.search.naver.com/search.naver?query=$query"
            val intent = Intent(Intent.ACTION_VIEW, android.net.Uri.parse(url))
            startActivity(intent)
        }

        // 설정 화면 이동
        btnSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}
