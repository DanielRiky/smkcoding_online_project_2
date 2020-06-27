package com.example.chalenge2

import ImsakFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val JUMLAH_MENU = 6
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> { return HomeFragment() }
            1 -> { return ImsakFragment() }
            2 -> { return CoronaFragment() }
            3 -> { return DzikirFragment() }
            4 -> { return MuhasabahFragment() }
            5 -> { return UserFragment() }


            else -> {
                return HomeFragment()
            }
        }
    }
    override fun getItemCount(): Int {
        return JUMLAH_MENU
    }
}