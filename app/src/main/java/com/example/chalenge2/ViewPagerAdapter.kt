package com.example.chalenge2

import ImsakFragment
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.chalenge2.CoronaFragment
import com.example.chalenge2.HomeFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val JUMLAH_MENU = 3
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> { return HomeFragment() }
            1 -> { return ImsakFragment() }
            2 -> { return CoronaFragment() }

            else -> {
                return HomeFragment()
            }
        }
    }
    override fun getItemCount(): Int {
        return JUMLAH_MENU
    }
}