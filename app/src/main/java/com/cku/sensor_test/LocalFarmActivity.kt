package com.cku.sensor_test

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LocalFarmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_farm)

        // 농장 목록 데이터
        val farmList = listOf(
            Farm("농장 A", "친환경 농업 기술을 사용하는 농장"),
            Farm("농장 B", "지능형 농업 솔루션 적용"),
            Farm("농장 C", "스마트팜 기술 연구 중"),
            Farm("농장 D", "지속 가능한 에너지 사용")
        )

        // RecyclerView 초기화
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FarmAdapter(this, farmList)
    }
}