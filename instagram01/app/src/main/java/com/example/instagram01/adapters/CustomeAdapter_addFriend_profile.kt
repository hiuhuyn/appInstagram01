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
import com.example.instagram01.interfaceFun.RvInterface_otherUser_profile
import com.example.instagram01.model.User

class CustomeRvAdapter_addFriend_profile(var list: ArrayList<User>, val rvInterface: RvInterface_otherUser_profile):RecyclerView.Adapter<CustomeRvAdapter_addFriend_profile.UserViewHolder>(){
    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    private lateinit var avt: ImageView
    private lateinit var userName: TextView
    private lateinit var btn_follow: Button
    private lateinit var img_close: ImageView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_witget_friend_profile, parent, false)
        return UserViewHolder(view)
    }
    private var array: ArrayList<User> = list


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemView.apply {
            val avt = this.findViewById<ImageView>(R.id.img_avt_friend)
            val userName = this.findViewById<TextView>(R.id.txt_user_name)
            val btn_follow = this.findViewById<Button>(R.id.btn_follow)
            val img_close = this.findViewById<ImageView>(R.id.img_close)
            img_close.setOnClickListener {
                rvInterface.OnClickClose(position)
                array.remove( list[position] )
                notifyDataSetChanged()
            }
            avt.setImageResource(array[position].Avt)
            userName.setText("${array[position].UserName}")

            var colorBtn: Int = 0
            var colorText: Int = 0
            btn_follow.setOnClickListener {
                var bool: Boolean = true
                if(btn_follow.text.equals("Theo dõi")){ // lúc click mà nút đang ở trạng thái theo dõi thì thay đổi
                    btn_follow.setText("Đang theo dõi")
                    colorBtn = ContextCompat.getColor(context, R.color.greyish)
                    colorText = ContextCompat.getColor(context, R.color.black)
                    btn_follow.setBackgroundColor(colorBtn)
                    btn_follow.setTextColor(colorText)
                    bool = true // follow
                }else{
                    btn_follow.setText("Theo dõi")
                    colorBtn = ContextCompat.getColor(context, R.color.blue)
                    colorText = ContextCompat.getColor(context, R.color.white)
                    btn_follow.setBackgroundColor(colorBtn)
                    btn_follow.setTextColor(colorText)
                    bool = false // unFollow
                }
                rvInterface.OnClickFollow(position, bool)
            }
            holder.itemView.setOnClickListener{
            }
        }
    }

    override fun getItemCount(): Int {
        if ( array.size > 10 ){
            return 10
        }else{
            return array.size
        }
    }
}