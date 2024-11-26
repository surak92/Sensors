package com.cku.sensor_test

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FarmAdapter(
    private val context: Context,
    private val farmList: List<Farm>
) : RecyclerView.Adapter<FarmAdapter.FarmViewHolder>() {

    // 뷰 홀더 정의
    class FarmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_farm_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_farm_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_farm, parent, false)
        return FarmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FarmViewHolder, position: Int) {
        val farm = farmList[position]
        holder.tvName.text = farm.name
        holder.tvDescription.text = farm.description

        // 클릭 이벤트 설정
        holder.itemView.setOnClickListener{
            val intent = Intent(context, FarmDetailActivity::class.java).apply {
                putExtra("farm_name", farm.name)
                putExtra("farm_description", farm.description)
            }
            if(farm.name.equals("농장 A") ) {
                context.startActivity(intent)
            }
            else{

            }
        }
    }

    override fun getItemCount(): Int {
        return farmList.size
    }
}
