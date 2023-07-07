package com.ramith.netclanexplorer.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ramith.netclanexplorer.ui.model.BusinessItem
import com.ramith.netclanexplorer.R

class RecyclerBusinessAdapter(val context: Context, val businessList: ArrayList<BusinessItem>): RecyclerView.Adapter<RecyclerBusinessAdapter.BusinessViewHolder>() {
    class BusinessViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtBusinessName: TextView = view.findViewById(R.id.txtBusinessName)
        val txtCityDistance: TextView = view.findViewById(R.id.txtCityDistance)
        val progressBar: ProgressBar = view.findViewById(R.id.progressBar)
        val flPhone: FrameLayout = view.findViewById(R.id.flPhone)
        val flContact: FrameLayout = view.findViewById(R.id.flContact)
        val txtProfessionExperience: TextView = view.findViewById(R.id.txtProfessionExperience)
        val about: TextView = view.findViewById(R.id.txtAbout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_business_line_item, parent, false)
        return BusinessViewHolder(view)
    }

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        val business = businessList[position]
        holder.txtBusinessName.text = business.businessName
        if(business.distance==0.0f){
            holder.txtCityDistance.text = business.cityName+", within "+ business.lowerDistanceRange.toString()+"-"+ business.upperDistanceRange.toString()+" m"
        } else{
            holder.txtCityDistance.text = business.cityName+", within "+business.distance.toString()+" KM"
        }
        if(business.purposes[0]==0){
            holder.flPhone.alpha=0.4f
        }
        if(business.purposes[1]==0){
            holder.flContact.alpha=0.4f
        }
        holder.progressBar.progress=business.progress
        holder.txtProfessionExperience.text = business.profession+" | "+business.experience.toString()+" years of experience"
        holder.about.text=business.about
    }

    override fun getItemCount(): Int {
        return businessList.size
    }

}