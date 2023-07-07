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
import com.ramith.netclanexplorer.ui.adapter.RecyclerPersonalAdapter
import com.ramith.netclanexplorer.ui.model.PersonItem

class PersonalFragment : Fragment() {

    lateinit var recyclerHome: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var recyclerAdapter: RecyclerPersonalAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personal, container, false)
        val searchView = view.findViewById<SearchView>(R.id.search_view)
        searchView.queryHint = "Search"

        var personList: ArrayList<PersonItem> = arrayListOf()
        val persosn1= PersonItem("Muskan Khan","Bangalore","Student",500,600,0.0f,35,
            arrayListOf("Coffee","Business","Friendship"),"Hi community! I am open to new connections \"😊\"")
        val persosn2= PersonItem("Tina Gidwani","Bengaluru","UI UX Designer",700,800,0.0f,47,
            arrayListOf("Coffee","Business","Friendship"),"Hi community! I am open to new connections \"😊\"\nHi, I'm Tina, a passionate UI/UX designer. With a focus on user-centric design principles, I graduated recently with expertise in Figma, Adobe XD and Illustrator. I bring fresh perspectives and creativity to digital experiences.")
        val persosn3= PersonItem("Pranjal Bharti","Bengaluru","Social Media Intern",0,0,1.1f,25,
            arrayListOf("Coffee","Business","Friendship"),"Hi community! I am open to new connections \"😊\"")
        personList.add(persosn1)
        personList.add(persosn2)
        personList.add(persosn3)

        layoutManager = LinearLayoutManager(activity)
        recyclerAdapter =
            RecyclerPersonalAdapter(activity as Context, personList)
        recyclerHome = view.findViewById(R.id.recyclerPersonal)
        recyclerHome.adapter = recyclerAdapter
        recyclerHome.layoutManager = layoutManager

        return view
    }
}