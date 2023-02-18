package com.example.instagram01.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentActivity
import com.example.instagram01.R
import com.example.instagram01.activity.HomePageActivity
import com.example.instagram01.model.*
import com.example.instagram01.reusable_classes.DataTest
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CustemerAdapter_comment(private val context: Context, val listComment: ArrayList<CommentStatus>)
    : ArrayAdapter<CommentStatus>(context, 0 , listComment) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var user: User = User()

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        createData(position)
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_witget_comment, parent, false)
        }

        val image = view?.findViewById<ImageView>(R.id.img_avt)
        if (image != null) {
            image.setImageURI(user.Avt)
        }

        val tv_userName = view?.findViewById<TextView>(R.id.tv_userName)
        if (tv_userName != null) {
            tv_userName.setText(user.UserName)
        }

        val tv_title = view?.findViewById<TextView>(R.id.tv_content)
        if (tv_title != null) {
            tv_title.setText(listComment[position].Content)
        }
        var dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val tv_time = view?.findViewById<TextView>(R.id.tv_time)
        if (tv_time != null) {
            tv_time.setText(dateFormat.format(listComment[position].CmtTime))
        }

        val img_btn_menu = view?.findViewById<ImageButton>(R.id.img_btn_menu)
        val tv_heart = view?.findViewById<TextView>(R.id.tv_heart)
        var isFavorite: Boolean = false
        var numberHeart = 0
        if (img_btn_menu != null) {
            img_btn_menu.setOnClickListener {
                if (isFavorite){
                    isFavorite=false
                    if (img_btn_menu != null) {
                        img_btn_menu.setBackgroundResource(R.drawable.heart1)
                        numberHeart-=1
                        if (tv_heart != null) {
                            tv_heart.setText(numberHeart.toString())
                        }
                    }
                    // khi nhấn hủy like

                }else{
                    isFavorite=true
                    if (img_btn_menu != null) {
                        img_btn_menu.setBackgroundResource(R.drawable.heart2)
                        numberHeart += 1
                        if (tv_heart != null) {
                            tv_heart.setText(numberHeart.toString())
                        }
                    }
                    // khi nhấn like
                }
            }
        }

        val comment_edit_text = view?.findViewById<EditText>(R.id.comment_edit_text)
        val tv_traloi = view?.findViewById<TextView>(R.id.tv_traloi)
        if (tv_traloi != null) {
            tv_traloi.setOnClickListener {
                if (comment_edit_text != null) {
                    comment_edit_text.setText(user.UserName)
                }
            }
        }
        return view!!
    }
    private fun createData(position: Int){
        user = User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "gynhuyn", "des", DataTest().imageUriTest(R.drawable.add))
    }
    }