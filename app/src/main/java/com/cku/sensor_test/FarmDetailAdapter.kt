package com.cku.sensor_test

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FarmDetailAdapter (
    private val context: Context,
    private val zones: List<zone>
) : RecyclerView.Adapter<FarmDetailAdapter.ZoneViewHolder>() {

    // 뷰 홀더 정의
    class ZoneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_zone_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_zone_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZoneViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_zone, parent, false)
        return ZoneViewHolder(view)
    }

    override fun onBindViewHolder(holder: ZoneViewHolder, position: Int) {
        val zone = zones[position]
        holder.tvName.text = zone.name
        holder.tvDescription.text = zone.description

        // 클릭 이벤트 설정
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ZoneActivity::class.java).apply {
                putExtra("zone_name", zone.name)
                putExtra("zone_description", zone.description)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return zones.size
    }
}