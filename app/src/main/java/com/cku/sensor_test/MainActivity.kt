package com.cku.sensor_test

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.devs.vectorchildfinder.VectorChildFinder


class MainActivity : AppCompatActivity() {

    private val gyeonggiArea = Rect(312, 412, 481, 641)
    private val gangwonArea = Rect(540, 300, 841, 562)
    private val chungnamArea = Rect(190, 702, 391, 902)
    private val chungbukArea_1 = Rect(540, 428, 841, 678)
    private val chungbukArea_2 = Rect(540, 428, 841, 678)
    private val jejuArea = Rect(182, 1779, 324, 1879)
    private val gyeongbukArea = Rect(540, 428, 841, 678)
    private val gyeongnamArea = Rect(540, 428, 841, 678)
    private val jeonbukArea = Rect(540, 428, 841, 678)
    private val jeonamArea = Rect(540, 428, 841, 678)
    private val sejongArea = Rect(540, 428, 841, 678)
    private val busanArea = Rect(540, 428, 841, 678)
    private val daeguArea = Rect(540, 428, 841, 678)
    private val incheonArea = Rect(540, 428, 841, 678)

    private var flag = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val iv_korea = findViewById<ImageView>(R.id.iv_korea)
        val vector = VectorChildFinder(this, R.drawable.map_of_south_korea_blank, iv_korea)

        val seoul = vector.findPathByName("서울특별시")
        val chungnam = vector.findPathByName("충청남도")
        val gangwon = vector.findPathByName("강원특별자치도")
        val jeju = vector.findPathByName("제주도")
        val chungbuk = vector.findPathByName("충청북도")
        val gyeonggi = vector.findPathByName("경기도")
        val gyeongbuk = vector.findPathByName("강원특별자치도")
        val gyeongnam = vector.findPathByName("제주도")
        val jeonbuk = vector.findPathByName("전라북도")
        val jeonam = vector.findPathByName("전라남도")
        val sejong = vector.findPathByName("세종특별자치시")
        val busan = vector.findPathByName("부산광역시")
        val daegu = vector.findPathByName("대구광역시")
        val incheon = vector.findPathByName("인천광역시")

        fun handleTouch(x: Int, y: Int) {
            when {
                gyeonggiArea.contains(x, y) -> {
                    flag = 0
                    showToast("경기/서울을 선택했습니다!")
                    seoul.fillColor = Color.GREEN
                    chungnam.fillColor = Color.rgb(205,204,204)
                    gangwon.fillColor = Color.rgb(205,204,204)
                    jeju.fillColor = Color.rgb(205,204,204)
                    chungbuk.fillColor = Color.rgb(205,204,204)
                    gyeonggi.fillColor = Color.GREEN
                    gyeongbuk.fillColor = Color.rgb(205,204,204)
                    gyeongnam.fillColor = Color.rgb(205,204,204)
                    jeonbuk.fillColor = Color.rgb(205,204,204)
                    jeonam.fillColor = Color.rgb(205,204,204)
                    sejong.fillColor = Color.rgb(205,204,204)
                    busan.fillColor = Color.rgb(205,204,204)
                    daegu.fillColor = Color.rgb(205,204,204)
                    incheon.fillColor = Color.rgb(205,204,204)
                    gangwon.fillColor = Color.rgb(205,204,204)
                    iv_korea.invalidate()
                }
                gangwonArea.contains(x, y) -> {
                    flag = flag+1
                    showToast("강원도를 선택했습니다!")
                    seoul.fillColor = Color.rgb(205,204,204)
                    chungnam.fillColor = Color.rgb(205,204,204)
                    jeju.fillColor = Color.rgb(205,204,204)
                    chungbuk.fillColor = Color.rgb(205,204,204)
                    gyeonggi.fillColor = Color.rgb(205,204,204)
                    gyeongbuk.fillColor = Color.rgb(205,204,204)
                    gyeongnam.fillColor = Color.rgb(205,204,204)
                    jeonbuk.fillColor = Color.rgb(205,204,204)
                    jeonam.fillColor = Color.rgb(205,204,204)
                    sejong.fillColor = Color.rgb(205,204,204)
                    busan.fillColor = Color.rgb(205,204,204)
                    daegu.fillColor = Color.rgb(205,204,204)
                    incheon.fillColor = Color.rgb(205,204,204)
                    gangwon.fillColor = Color.GREEN
                    iv_korea.invalidate()
                    if(flag == 2) {
                        val intent = Intent(this, LocalFarmActivity::class.java)
                        startActivity(intent)
                    }
                }
                jejuArea.contains(x, y) -> {
                    flag = 0
                    showToast("제주도를 선택했습니다!")
                    gangwon.fillColor = Color.rgb(205,204,204)
                    seoul.fillColor = Color.rgb(205,204,204)
                    chungnam.fillColor = Color.rgb(205,204,204)
                    gangwon.fillColor = Color.rgb(205,204,204)
                    chungbuk.fillColor = Color.rgb(205,204,204)
                    gyeonggi.fillColor = Color.rgb(205,204,204)
                    gyeongbuk.fillColor = Color.rgb(205,204,204)
                    gyeongnam.fillColor = Color.rgb(205,204,204)
                    jeonbuk.fillColor = Color.rgb(205,204,204)
                    jeonam.fillColor = Color.rgb(205,204,204)
                    sejong.fillColor = Color.rgb(205,204,204)
                    busan.fillColor = Color.rgb(205,204,204)
                    daegu.fillColor = Color.rgb(205,204,204)
                    incheon.fillColor = Color.rgb(205,204,204)
                    jeju.fillColor = Color.GREEN
                    iv_korea.invalidate()
                }
                chungnamArea.contains(x, y) ->{
                    flag = 0
                    showToast("충청남도를 선택했습니다!")
                    gangwon.fillColor = Color.rgb(205,204,204)
                    seoul.fillColor = Color.rgb(205,204,204)
                    gangwon.fillColor = Color.rgb(205,204,204)
                    chungbuk.fillColor = Color.rgb(205,204,204)
                    gyeonggi.fillColor = Color.rgb(205,204,204)
                    gyeongbuk.fillColor = Color.rgb(205,204,204)
                    gyeongnam.fillColor = Color.rgb(205,204,204)
                    jeonbuk.fillColor = Color.rgb(205,204,204)
                    jeonam.fillColor = Color.rgb(205,204,204)
                    sejong.fillColor = Color.rgb(205,204,204)
                    busan.fillColor = Color.rgb(205,204,204)
                    daegu.fillColor = Color.rgb(205,204,204)
                    incheon.fillColor = Color.rgb(205,204,204)
                    jeju.fillColor = Color.rgb(205,204,204)
                    chungnam.fillColor = Color.GREEN
                    iv_korea.invalidate()
                }
            }
        }

        iv_korea.setOnTouchListener { _, event ->
            Log.d("좌표", "x: ${event.x.toInt()}, y: ${event.y.toInt()}")
            if (event.action == MotionEvent.ACTION_DOWN) {
                handleTouch(event.x.toInt(), event.y.toInt())
            }
            true
        }
        iv_korea.invalidate()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}