package com.cku.sensor_test

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FarmDetailActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farm_detail)

        // 전달된 데이터 가져오기
        val name = intent.getStringExtra("farm_name")
        val description = intent.getStringExtra("farm_description")

        val zones = listOf(
            zone("전체 구역", "농장의 모든 구역을 포함한 정보"),
            zone("구역 1", "채소 재배 구역"),
            zone("구역 2", "온실 구역"),
            zone("구역 3", "수경재배 구역"),
            zone("구역 4", "작물 연구 구역")
        )

        // 텍스트뷰에 데이터 표시
        findViewById<TextView>(R.id.tv_farm_name).text = name
        findViewById<TextView>(R.id.tv_farm_description).text = description

        // RecyclerView 초기화
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_zones)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FarmDetailAdapter(this, zones)
    }
}