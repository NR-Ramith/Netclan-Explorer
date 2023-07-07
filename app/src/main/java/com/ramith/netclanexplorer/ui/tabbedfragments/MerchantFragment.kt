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
import com.ramith.netclanexplorer.ui.adapter.RecyclerMerchantAdapter
import com.ramith.netclanexplorer.ui.model.MerchantItem

class MerchantFragment : Fragment() {

    lateinit var recyclerHome: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var recyclerAdapter: RecyclerMerchantAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_merchant, container, false)
        val searchView = view.findViewById<SearchView>(R.id.search_view)
        searchView.queryHint = "Search"

        var merchantList: ArrayList<MerchantItem> = arrayListOf()
        val merchant1= MerchantItem("FloCar's-Self Drive Car Rental's","Bengaluru",500,600,0.0f,75,
            arrayListOf(1,1,1), "Hi community! We have great deals for you. Check us out!!","Car leasing service")
        val merchant2= MerchantItem("Travel Amante","Bengaluru",800,900,0.0f,70,
            arrayListOf(1,1,1), "Hi community! We have great deals for you. Check us out!!","Travel agency")
        val merchant3= MerchantItem("Caramelts Cafe & Charcoal","Bengaluru",0,0,1.3f,67,
            arrayListOf(1,1,1), "Hi community! We have great deals for you. Check us out!!","Pizza restaurant")
        merchantList.add(merchant1)
        merchantList.add(merchant2)
        merchantList.add(merchant3)

        layoutManager = LinearLayoutManager(activity)
        recyclerAdapter =
            RecyclerMerchantAdapter(activity as Context, merchantList)
        recyclerHome = view.findViewById(R.id.recyclerMerchant)
        recyclerHome.adapter = recyclerAdapter
        recyclerHome.layoutManager = layoutManager
        return view
    }
}