package com.cku.sensor_test

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ZoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sector)

        // 전달받은 구역 정보
        val zoneName = intent.getStringExtra("zone_name")
        val zoneDescription = intent.getStringExtra("zone_description")

        // 구역 정보 표시
        findViewById<TextView>(R.id.tv_zone_name).text = zoneName
        findViewById<TextView>(R.id.tv_zone_description).text = zoneDescription
    }
}