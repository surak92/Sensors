package com.cku.sensor_test

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.devs.vectorchildfinder.VectorChildFinder


class MainActivity : AppCompatActivity() {

    private val gyeonggiArea = Rect(312, 412, 481, 641)
    private val gangwonArea = Rect(540, 300, 841, 562)
    private val chungnamArea = Rect(190, 702, 391, 902)
    private val chungbukArea_1 = Rect(484, 735, 548, 945)
    private val chungbukArea_2 = Rect(465, 680, 660, 709)
    private val jejuArea = Rect(180, 1684, 324, 1764)
    private val gyeongbukArea = Rect(624, 741, 932, 959)
    private val gyeongnamArea = Rect(530, 1075, 774, 1191)
    private val jeonbukArea = Rect(302, 965, 472, 1119)
    private val jeonnamArea = Rect(200, 1165, 518, 1451)
    private val sejongArea = Rect(396, 771, 430, 827)
    private val busanArea = Rect(806, 1159, 884, 1219)
    private val ulsanArea = Rect(844, 1055, 916, 1133)
    private val daeguArea = Rect(690, 985, 722, 1051)
    private val incheonArea = Rect(262, 521, 292, 565)
    private val daejeonArea = Rect(424, 855, 460, 894)

    private var flag = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val iv_korea = findViewById<ImageView>(R.id.iv_korea)
        val vector = VectorChildFinder(this, R.drawable.map_of_south_korea_blank, iv_korea)
        val text = findViewById<TextView>(R.id.local)
        val color_basic = Color.rgb(205,204,204)

        val local = arrayOf(
            vector.findPathByName("서울특별시"),//0
            vector.findPathByName("충청남도"),//1
            vector.findPathByName("강원특별자치도"),//2
            vector.findPathByName("제주도"),//3
            vector.findPathByName("충청북도"),//4
            vector.findPathByName("경기도"),//5
            vector.findPathByName("강원특별자치도"),//6
            vector.findPathByName("제주도"),//7
            vector.findPathByName("전라북도"),//8
            vector.findPathByName("전라남도"),//9
            vector.findPathByName("세종특별자치시"),//10
            vector.findPathByName("부산광역시"),//11
            vector.findPathByName("대구광역시"),//12
            vector.findPathByName("인천광역시"),//13
            vector.findPathByName("경상북도"),//14
            vector.findPathByName("경상남도"),//15
            vector.findPathByName("울산광역시"),//16
            vector.findPathByName("광주광역시"),//17
            vector.findPathByName("대전광역시")//18
        )

        fun select_local(flag_in: Int){
            if(flag == 2){
                val intent = Intent(this, LocalFarmActivity::class.java)
                startActivity(intent)
                flag = 0
            }
            if(flag == flag_in){
                showToast("해당 지역은 아직 준비중입니다!")
                flag = 0
            }
            else{
                flag =flag_in
            }
            text.text = "${local[flag_in].pathName}를 선택했습니다!"
            for(i in 0 until local.size)
                local[i].fillColor = color_basic
            local[flag_in].fillColor = Color.GREEN
            if(flag_in == 5){
                local[0].fillColor = Color.GREEN
            }
            if(flag_in == 9){
                local[17].fillColor = Color.GREEN
            }
        }

        fun handleTouch(x: Int, y: Int) {
            when {
                gyeonggiArea.contains(x, y) -> {
                    select_local(5)
                    iv_korea.invalidate()
                }
                gangwonArea.contains(x, y) -> {
                    select_local(2)
                    iv_korea.invalidate()
                }
                jejuArea.contains(x, y) -> {
                    select_local(7)
                    iv_korea.invalidate()
                }
                chungnamArea.contains(x, y) -> {
                    select_local(1)
                    iv_korea.invalidate()
                }
                chungbukArea_1.contains(x, y) -> {
                    select_local(4)
                    iv_korea.invalidate()
                }
                chungbukArea_2.contains(x, y) -> {
                    select_local(4)
                    iv_korea.invalidate()
                }
                gyeongbukArea.contains(x, y) -> {
                    select_local(14)
                    iv_korea.invalidate()
                }
                gyeongnamArea.contains(x, y) -> {
                    select_local(15)
                    iv_korea.invalidate()
                }
                jeonbukArea.contains(x, y) -> {
                    select_local(8)
                    iv_korea.invalidate()
                }
                jeonnamArea.contains(x, y) -> {
                    select_local(9)
                    iv_korea.invalidate()
                }
                sejongArea.contains(x, y) -> {
                    select_local(10)
                    iv_korea.invalidate()
                }
                busanArea.contains(x, y) -> {
                    select_local(11)
                    iv_korea.invalidate()
                }
                daeguArea.contains(x, y) -> {
                    select_local(12)
                    iv_korea.invalidate()
                }
                incheonArea.contains(x, y) -> {
                    select_local(13)
                    iv_korea.invalidate()
                }
                ulsanArea.contains(x, y) -> {
                    select_local(16)
                    iv_korea.invalidate()
                }
                daejeonArea.contains(x, y) -> {
                    select_local(18)
                    iv_korea.invalidate()
                }
            }
        }

        iv_korea.setOnTouchListener { _, event ->
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