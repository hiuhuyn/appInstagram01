package com.example.instagram01.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.instagram01.R
import com.example.instagram01.activity.HomePageActivity
import com.example.instagram01.model.User
import java.util.*
import kotlin.collections.ArrayList

class CustemerAdapter_status_Search(val activity: HomePageActivity, var array:ArrayList<User>)
    : ArrayAdapter<User>(activity, R.layout.item_witget_user_follow),Filterable {

    lateinit var arrayfilter:ArrayList<User>

    fun setData(array: ArrayList<User>){
        this.arrayfilter = array
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return array.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = activity.layoutInflater.inflate(R.layout.item_witget_user_follow, parent, false)
        val img_avt = view.findViewById<ImageView>(R.id.img_avt)
        val tv_userName = view.findViewById<TextView>(R.id.tv_userName)
        val tv_fullName = view.findViewById<TextView>(R.id.tv_fullName)
        val btn = view.findViewById<Button>(R.id.btn_follow)

        img_avt.setImageURI(array[position].Avt)
        tv_userName.setText(array[position].UserName)
        tv_fullName.setText(array[position].FullName)

        btn.setVisibility(View.GONE)

        return view
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(charsequence: CharSequence?): FilterResults {
                val filterResults = FilterResults()

                if (charsequence == null || charsequence.length < 0 ){
                    filterResults.count = arrayfilter.size
                    filterResults.values = arrayfilter
                }else{
                    var searchChr = charsequence.toString().lowercase(Locale.ROOT)
                    val user = ArrayList<User>()

                    for (item in arrayfilter){
                        if (item.UserName.contains(searchChr)||item.FullName.contains(searchChr)){
                            user.add(item)
                        }
                    }
                    filterResults.count = user.size
                    filterResults.values = user
                }
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, filterResults: FilterResults?) {
                array = filterResults!!.values as ArrayList<User>
                notifyDataSetChanged()
            }
        }
    }
}