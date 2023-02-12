package com.example.instagram01.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram01.R
import com.example.instagram01.interfaceFun.OnClickListent
import com.example.instagram01.model.User

class CustomeRvAdapter_addFriend_profile(val array: ArrayList<User>, val rvInterface: OnClickListent):RecyclerView.Adapter<CustomeRvAdapter_addFriend_profile.UserViewHolder>(){
    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_witget_friend_profile, parent, false)
        return UserViewHolder(view)
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemView.apply {
            val avt = this.findViewById<ImageView>(R.id.img_avt_friend)
            val userName = this.findViewById<TextView>(R.id.txt_user_name)
            val btn_follow = this.findViewById<Button>(R.id.btn_follow)
            val img_close = this.findViewById<ImageView>(R.id.img_close)

            avt.setImageURI(array[position].Avt)
            userName.setText("${array[position].UserName}")
            var colorBtn: Int = 0
            var colorText: Int = 0
            var isFollow = false
            btn_follow.setOnClickListener {
                if(!isFollow){ // lúc click mà nút đang ở trạng thái theo dõi thì thay đổi
                    btn_follow.setText("Đang theo dõi")
                    colorBtn = ContextCompat.getColor(context, R.color.greyish)
                    colorText = ContextCompat.getColor(context, R.color.black)
                    btn_follow.setBackgroundColor(colorBtn)
                    btn_follow.setTextColor(colorText)
                    isFollow = true
                }else{
                    btn_follow.setText("Theo dõi")
                    colorBtn = ContextCompat.getColor(context, R.color.blue)
                    colorText = ContextCompat.getColor(context, R.color.white)
                    btn_follow.setBackgroundColor(colorBtn)
                    btn_follow.setTextColor(colorText)
                    isFollow = false
                }
            }
            img_close.setOnClickListener {
                rvInterface.OnClickClose(position)
                array.remove( array[position] )
                notifyDataSetChanged()
            }
            avt.setOnClickListener {
                rvInterface.OnClickView(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return if ( array.size > 10 ){
            10
        }else{
            array.size
        }
    }
}