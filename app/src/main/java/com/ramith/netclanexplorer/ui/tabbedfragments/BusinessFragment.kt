package com.ramith.netclanexplorer.ui.tabbedfragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramith.netclanexplorer.R
import com.ramith.netclanexplorer.ui.adapter.RecyclerBusinessAdapter
import com.ramith.netclanexplorer.ui.model.BusinessItem

class BusinessFragment : Fragment() {

    lateinit var recyclerHome: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var recyclerAdapter: RecyclerBusinessAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_business, container, false)
        val searchView = view.findViewById<SearchView>(R.id.search_view)
        searchView.queryHint = "Search"

        var businessList: ArrayList<BusinessItem> = arrayListOf()
        val business1= BusinessItem("Soubhagyalaxmi Maharana","Bangalore",0,0,1.6f,35,
            arrayListOf(1,1),"Software Test Engineer",2, "Hi community! I am available at your service!")
        val business2= BusinessItem("Goutham S","Bangalore",0,0,1.7f,30,
            arrayListOf(1,1),"Bachelor Student",0, "Hi community! I am available at your service!")
        val business3= BusinessItem("Ratan B","Bengaluru",0,0,2.8f,65,
            arrayListOf(0,1),"Qa Analyst",1, "Hi community! I am available at your service!\n• Perform testing on Drivelah (Singapore product) and Drivemate (Australia product). Every need to do testing on website / IOS / Android application\n• Successfully setup the QA operation for above 2 products\n" +
                    "• Implemented functional, unit, and integration tests for iOS, Android, and web applications resulting in a 80% reduction in customer-reported defects.\n• Played a key role in maintaining 99.99% uptime for the production environment by performing rigorous UAT, alpha and beta testing.")
        businessList.add(business1)
        businessList.add(business2)
        businessList.add(business3)

        layoutManager = LinearLayoutManager(activity)
        recyclerAdapter =
            RecyclerBusinessAdapter(activity as Context, businessList)
        recyclerHome = view.findViewById(R.id.recyclerBusiness)
        recyclerHome.adapter = recyclerAdapter
        recyclerHome.layoutManager = layoutManager
        return view
    }
}