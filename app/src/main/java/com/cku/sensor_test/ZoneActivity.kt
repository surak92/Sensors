package com.cku.sensor_test

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class ZoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sector)

        // 전달받은 구역 정보
        val zoneName = intent.getStringExtra("zone_name")
        val zoneDescription = intent.getStringExtra("zone_description")

        val moistureData = listOf(10f, 15f, 20f, 25f, 30f)  // 수분 함량
        val ecData = listOf(1.0f, 1.2f, 1.5f, 1.8f, 2.0f)    // EC 값
        val phData = listOf(6.5f, 6.6f, 6.8f, 7.0f, 7.2f)    // pH 값
        val reflectanceData = listOf(30f, 35f, 40f, 45f, 50f) // 반사도
        val rgbImageResource = R.drawable.ic_launcher_background // RGB 영상

        // 구역 정보 표시
        findViewById<TextView>(R.id.tv_zone_name).text = zoneName
        findViewById<TextView>(R.id.tv_zone_description).text = zoneDescription

        setupLineChart(findViewById(R.id.chart_moisture), "수분 함량", moistureData)
        setupLineChart(findViewById(R.id.chart_ec), "EC 값", ecData)
        setupLineChart(findViewById(R.id.chart_ph), "pH 값", phData)
        setupLineChart(findViewById(R.id.chart_reflectance), "반사도", reflectanceData)

        // RGB 영상 표시
        findViewById<ImageView>(R.id.iv_rgb_image).setImageResource(rgbImageResource)
    }

    // LineChart 데이터 설정
    private fun setupLineChart(chart: LineChart, label: String, data: List<Float>) {
        val entries = data.mapIndexed { index, value -> Entry(index.toFloat(), value) }
        val dataSet = LineDataSet(entries, label)
        dataSet.color = resources.getColor(R.color.black, theme)  // 라인 색상
        dataSet.valueTextColor = resources.getColor(R.color.black, theme)  // 값 텍스트 색상
        val lineData = LineData(dataSet)
        chart.data = lineData
        chart.invalidate()  // 그래프 새로고침
    }
}