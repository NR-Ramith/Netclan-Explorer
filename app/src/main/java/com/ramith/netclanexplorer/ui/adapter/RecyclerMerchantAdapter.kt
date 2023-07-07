package com.ramith.netclanexplorer.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ramith.netclanexplorer.ui.model.MerchantItem
import com.ramith.netclanexplorer.R

class RecyclerMerchantAdapter(val context: Context, val merchantList: ArrayList<MerchantItem>): RecyclerView.Adapter<RecyclerMerchantAdapter.MerchantViewHolder>() {
    class MerchantViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtMerchantName: TextView = view.findViewById(R.id.txtMerchantName)
        val txtCityDistance: TextView = view.findViewById(R.id.txtCityDistance)
        val progressBar: ProgressBar = view.findViewById(R.id.progressBar)
        val flPhone: FrameLayout = view.findViewById(R.id.flPhone)
        val flContact: FrameLayout = view.findViewById(R.id.flContact)
        val flLocation: FrameLayout = view.findViewById(R.id.flLocation)
        val txtService: TextView = view.findViewById(R.id.txtService)
        val txtAbout: TextView = view.findViewById(R.id.txtAbout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MerchantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_merchant_line_item, parent, false)
        return MerchantViewHolder(view)
    }

    override fun onBindViewHolder(holder: MerchantViewHolder, position: Int) {
        val merchant = merchantList[position]
        holder.txtMerchantName.text = merchant.merchantName
        if(merchant.distance==0.0f){
            holder.txtCityDistance.text = merchant.cityName+", within "+ merchant.lowerDistanceRange.toString()+"-"+ merchant.upperDistanceRange.toString()+" m"
        } else{
            holder.txtCityDistance.text = merchant.cityName+", within "+merchant.distance.toString()+" KM"
        }
        if(merchant.purposes[0]==0){
            holder.flPhone.alpha=0.4f
        }
        if(merchant.purposes[1]==0){
            holder.flContact.alpha=0.4f
        }
        if(merchant.purposes[2]==0){
            holder.flLocation.alpha=0.4f
        }
        holder.progressBar.progress=merchant.progress
        holder.txtAbout.text=merchant.about
        holder.txtService.text=merchant.service
    }

    override fun getItemCount(): Int {
        return merchantList.size
    }

}