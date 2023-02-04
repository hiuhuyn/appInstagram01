package com.example.instagram01.adapters

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.instagram01.Fragments.status.Fragment_itemImage

import com.example.instagram01.R
import com.example.instagram01.model.ImageStaus

interface MoveItemViewPage{
    fun MoveItem(position: Int)
}
open class MyPageChangeCallback(val moveItemViewPage: MoveItemViewPage) : ViewPager2.OnPageChangeCallback() {
    override fun onPageSelected(position: Int) {
        super.onPageSelected(position)
        moveItemViewPage.MoveItem(position)
    }
}
class ViewPageAdapter_iamgeStatus(activity: Fragment, val list: ArrayList<ImageStaus>): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return Fragment_itemImage.newInstance(list[position].SrcImg)
    }

}