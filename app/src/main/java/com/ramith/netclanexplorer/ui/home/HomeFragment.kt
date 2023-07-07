package com.ramith.netclanexplorer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ramith.netclanexplorer.ui.tabbedfragments.BusinessFragment
import com.ramith.netclanexplorer.ui.tabbedfragments.MerchantFragment
import com.ramith.netclanexplorer.ui.tabbedfragments.PersonalFragment
import com.ramith.netclanexplorer.R

class HomeFragment : Fragment() {

    private val PAGE_TITLES = arrayOf(
        "Personal",
        "Business",
        "Merchant"
    )

    private val PAGES = arrayOf(
        PersonalFragment(),
        BusinessFragment(),
        MerchantFragment()
    )

    private lateinit var mViewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_explore, container, false)

        mViewPager = rootView.findViewById(R.id.bottom_view_pager)
        mViewPager.adapter = MyPagerAdapter(childFragmentManager)

        val tabLayout: TabLayout = rootView.findViewById(R.id.tabs)
        tabLayout.setupWithViewPager(mViewPager)

        return rootView
    }

    inner class MyPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int): Fragment {
            return PAGES[position]
        }

        override fun getCount(): Int {
            return PAGES.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return PAGE_TITLES[position]
        }
    }
}
