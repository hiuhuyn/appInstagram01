package com.example.instagram01.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.instagram01.R
import com.example.instagram01.activity.HomePageActivity
import com.example.instagram01.model.*
import com.example.instagram01.reusable_classes.DataTest
import com.google.android.material.bottomsheet.BottomSheetDialog
import me.relex.circleindicator.CircleIndicator3
import java.text.SimpleDateFormat
import java.util.Calendar

class CustemerAdapter_status(val fragmentActivity: FragmentActivity, val listStatus: ArrayList<Status>, var fragment: Fragment): ArrayAdapter<Status>(fragmentActivity, R.layout.item_witget_status),
    Filterable {


    private var listImages = ArrayList<ImageStaus>()
    private var listLike = ArrayList<LikeStatus>()
    private var listComment= ArrayList<CommentStatus>()
    private var user: User = User()
    lateinit var arrayfilter:ArrayList<Status>

    fun setData(array: ArrayList<User>){
        this.arrayfilter = listStatus
        notifyDataSetChanged()
    }


    override fun getCount(): Int {
        return listStatus.size
    }


    private fun createData(position: Int){
        listImages.clear()
        listLike.clear()
        listComment.clear()
        val userName = listStatus[position].UserName
        /*
        ở đây gửi các yêu cầu lấy dữ liệu
        1. Lấy thông tin của user == UserName
        2. Lấy thông tin các lượt like vào status này  == idStatus
        3. Lấy thông tin các comment của status == idStatus
        4. Lấy các ảnh/video của bài viết này
         */

        // dũ liệu ảo
        user = User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "gynhuyn", "des", DataTest().imageUriTest(R.drawable.add))
        listImages.add(ImageStaus(0, 0, DataTest().imageUriTest(R.drawable.add)))
        listImages.add(ImageStaus(1, 1, DataTest().imageUriTest(R.drawable.avt_test)))
        listImages.add(ImageStaus(2, 2, DataTest().imageUriTest(R.drawable.ic_close_x)))
        listImages.add(ImageStaus(3, 3, DataTest().imageUriTest(R.drawable.add_friend1)))
        listImages.add(ImageStaus(4, 4, DataTest().imageUriTest(R.drawable.add_friend2)))
        listImages.add(ImageStaus(5, 5, DataTest().imageUriTest(R.drawable.messenger)))

        listLike.add(LikeStatus(1, listStatus[position].IdStatus, "", Calendar.getInstance().time ))
        listLike.add(LikeStatus(2, listStatus[position].IdStatus, "", Calendar.getInstance().time ))
        listLike.add(LikeStatus(3, listStatus[position].IdStatus, "", Calendar.getInstance().time ))
        listLike.add(LikeStatus(4, listStatus[position].IdStatus, "", Calendar.getInstance().time ))
        listLike.add(LikeStatus(5, listStatus[position].IdStatus, "", Calendar.getInstance().time ))
        listLike.add(LikeStatus(6, listStatus[position].IdStatus, "", Calendar.getInstance().time ))
        listLike.add(LikeStatus(7, listStatus[position].IdStatus, "", Calendar.getInstance().time ))
        listLike.add(LikeStatus(8, listStatus[position].IdStatus, "", Calendar.getInstance().time ))
        listLike.add(LikeStatus(9, listStatus[position].IdStatus, "", Calendar.getInstance().time ))
        listLike.add(LikeStatus(10, listStatus[position].IdStatus, "", Calendar.getInstance().time ))
        listLike.add(LikeStatus(11, listStatus[position].IdStatus, "", Calendar.getInstance().time ))


        listComment.add(CommentStatus(1, listStatus[position].IdStatus, "", "Hegh", Calendar.getInstance().time ))
        listComment.add(CommentStatus(2, listStatus[position].IdStatus, "", "Hegh", Calendar.getInstance().time ))
        listComment.add(CommentStatus(3, listStatus[position].IdStatus, "", "Hegh", Calendar.getInstance().time ))
        listComment.add(CommentStatus(4, listStatus[position].IdStatus, "", "Hegh", Calendar.getInstance().time ))
        listComment.add(CommentStatus(5, listStatus[position].IdStatus, "", "Hegh", Calendar.getInstance().time ))
        listComment.add(CommentStatus(6, listStatus[position].IdStatus, "", "Hegh", Calendar.getInstance().time ))
        listComment.add(CommentStatus(7, listStatus[position].IdStatus, "", "Hegh", Calendar.getInstance().time ))
        listComment.add(CommentStatus(8, listStatus[position].IdStatus, "", "Hegh", Calendar.getInstance().time ))





    }


    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        createData(position)

        val view = fragmentActivity.layoutInflater.inflate(R.layout.item_witget_status, parent, false)
        val img_avt = view.findViewById<ImageView>(R.id.img_avt)
        val tv_userName = view.findViewById<TextView>(R.id.tv_userName)
        val tv_time = view.findViewById<TextView>(R.id.tv_time)
        val img_btn_menu = view.findViewById<ImageButton>(R.id.img_btn_menu)
        val tv_title = view.findViewById<TextView>(R.id.tv_title)
        val viewPager2_img = view.findViewById<ViewPager2>(R.id.viewPager2_img)
        val tv_countImg = view.findViewById<TextView>(R.id.tv_countImg)
        val img_btn_favorite = view.findViewById<ImageButton>(R.id.img_btn_favorite)
        val img_btn_comment = view.findViewById<ImageButton>(R.id.img_btn_comment)
        val img_btn_save = view.findViewById<ImageButton>(R.id.img_btn_save)
        val tv_showLike = view.findViewById<TextView>(R.id.tv_showLike)

        img_avt.setImageURI(user.Avt)
        tv_userName.setText(user.UserName)
        var dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        tv_time.setText(dateFormat.format(listStatus[position].PostTime))
        tv_title.setText(listStatus[position].Title)
        tv_showLike.setText("${listLike.size} yêu thích, ${listComment.size} bình luận")


        if (listImages.size <=1){
            tv_countImg.visibility = View.GONE
        }else{
            tv_countImg.visibility = View.VISIBLE
        }
        viewPager2_img.adapter = ViewPageAdapter_iamgeStatus(fragment, listImages)
        val myPageChangeCallback = MyPageChangeCallback(object : MoveItemViewPage{
            override fun MoveItem(position: Int) {
                tv_countImg.setText("${position+1}/${listImages.size}")
            }

        })
        viewPager2_img.registerOnPageChangeCallback(myPageChangeCallback)
        val indicator = view.findViewById<CircleIndicator3>(R.id.circle_indicator3)
        indicator.setViewPager(viewPager2_img)




        var isFavorite: Boolean = false // sau chuyển thành kiểm tra từ dữ liệu
        img_btn_favorite.setOnClickListener {
            if (isFavorite){
                isFavorite=false
                img_btn_favorite.setImageResource(R.drawable.heart1)
                // khi nhấn hủy like

            }else{
                isFavorite=true
                img_btn_favorite.setImageResource(R.drawable.heart2)
                // khi nhấn like
            }
        }
        var isSave = false
        img_btn_save.setOnClickListener {
            if (isSave){
                isSave=false
                img_btn_save.setImageResource(R.drawable.save_1)
                // khi nhấn hủy like

            }else{
                isSave=true
                img_btn_save.setImageResource(R.drawable.save_2)
                // khi nhấn like
            }

        }
        val inflater = LayoutInflater.from(context)
        img_btn_comment.setOnClickListener {
            var view = inflater.inflate(R.layout.comment_sheet, null)
            val bottomSheetDialog = BottomSheetDialog(context)
            bottomSheetDialog.setContentView(view)
            val listViewComments = view.findViewById<ListView>(R.id.comment_list_view)
            val comment_button = view.findViewById<Button>(R.id.comment_button)
            val comment_edit_text = view.findViewById<EditText>(R.id.comment_edit_text)
            // Tạo một Adapter để hiển thị danh sách bình luận
            val adapter = CustemerAdapter_comment(context, listComment)
            listViewComments.adapter = adapter
            comment_button.setOnClickListener {
                val text = comment_edit_text.text.toString()
                var id = 8
                if (text.isNotEmpty()){
                    id += 1
                    listComment.add(CommentStatus(id, listStatus[position].IdStatus, "yutar", text, Calendar.getInstance().time ))
                    (listViewComments.adapter as CustemerAdapter_comment).notifyDataSetChanged()
                    comment_edit_text.text.clear()
                }
            }
            bottomSheetDialog.show()
        }

        img_btn_menu.setOnClickListener {

        }




        return view
    }
}