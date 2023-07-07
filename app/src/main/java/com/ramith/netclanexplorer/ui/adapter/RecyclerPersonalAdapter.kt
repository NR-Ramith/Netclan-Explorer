package com.ramith.netclanexplorer.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ramith.netclanexplorer.ui.model.PersonItem
import com.ramith.netclanexplorer.R

class RecyclerPersonalAdapter(val context: Context, val personList: ArrayList<PersonItem>): RecyclerView.Adapter<RecyclerPersonalAdapter.PersonalViewHolder>() {
    class PersonalViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtPersonName: TextView = view.findViewById(R.id.txtPersonName)
        val txtCityProfession: TextView = view.findViewById(R.id.txtCityProfession)
        val txtDistance: TextView = view.findViewById(R.id.txtDistance)
        val progressBar: ProgressBar = view.findViewById(R.id.progressBar)
        val purposes: TextView = view.findViewById(R.id.txtPurposes)
        val status: TextView = view.findViewById(R.id.txtStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_personal_line_item, parent, false)
        return PersonalViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonalViewHolder, position: Int) {
        val person = personList[position]
        holder.txtPersonName.text = person.personName
        holder.txtCityProfession.text = person.cityName+" | "+person.profession
        if(person.distance==0.0f){
            holder.txtDistance.text = "Within "+ person.lowerDistanceRange.toString()+"-"+ person.upperDistanceRange.toString()+" m"
        } else{
            holder.txtDistance.text = "Within "+ person.distance+" KM"
        }
        holder.progressBar.progress=person.progress
        holder.purposes.text = person.purposes[0]
        val purposeSize=person.purposes.size
        if(purposeSize>1){
            for (p in 1 until purposeSize step 1) {
                holder.purposes.text = holder.purposes.text as String + " | "+person.purposes[p]
            }
        }
        holder.status.text=person.status
    }

    override fun getItemCount(): Int {
        return personList.size
    }

}