package com.example.instagram01.Fragments.profile

import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram01.Fragments.follow.Fragment_showFollow
import com.example.instagram01.Fragments.profile.child_profile.Fragment_showAllOtherUser
import com.example.instagram01.Fragments.status.Fragment_showStatus_User
import com.example.instagram01.R
import com.example.instagram01.activity.EditProfile_Activity
import com.example.instagram01.activity.HomePageActivity
import com.example.instagram01.adapters.CustomeRvAdapter_addFriend_profile
import com.example.instagram01.adapters.CustomerAdapter_status_profile
import com.example.instagram01.interfaceFun.OnClickListent
import com.example.instagram01.model.ImageStaus
import com.example.instagram01.model.Status
import com.example.instagram01.model.User
import com.example.instagram01.reusable_classes.DataTest
import java.util.Calendar


private const val ARG_IS_USER_MAIN = "isusermain"
private const val ARG_IS_USER_OTHER = "userother"


class Fragment_profile : Fragment() {
    private lateinit var mainActivity: HomePageActivity

    private var listStatus:ArrayList<Status> = ArrayList()
    private var listImages: ArrayList<ImageStaus> = ArrayList()
    private var listUser: ArrayList<User> = ArrayList()

    private lateinit var rv_otherUser: RecyclerView

    private lateinit var gv_listStatus: GridView
    private lateinit var btn_editProfile: Button
    private lateinit var img_showOtherUser: ImageView
    private lateinit var ll0status: LinearLayout
    private lateinit var liearLayout_ohterUser_profile: LinearLayout
    private lateinit var btn_showAllOtherUser: Button
    private lateinit var txt_showAllOtherUser: TextView
    private lateinit var linearLayout_followers: LinearLayout
    private lateinit var linearLayout_followed: LinearLayout
    private lateinit var linearLayout_follow_messenger: LinearLayout
    private lateinit var txt_name_profile: TextView
    private lateinit var txt_desc_profile: TextView
    private lateinit var img_avt_profile: ImageView
    private lateinit var btn_follow: Button
    private lateinit var btn_messenger: Button



    private var isUserMain: Boolean = false
    private var user: User = User()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            isUserMain = it.getBoolean(ARG_IS_USER_MAIN)
            user.UserName = it.getString(ARG_IS_USER_OTHER).toString()
        }

    }

    private fun setUser(userName: String) {
        // lấy dữ liệu qua userName
        if(isUserMain){
            val myperf: SharedPreferences = mainActivity.getSharedPreferences("dataSave",
                AppCompatActivity.MODE_PRIVATE
            )
            val un = myperf.getString("userName",userName).toString()
            user = User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", un, "des", DataTest().imageUriTest(R.drawable.user ))

        }else{
            user = User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", userName, "des", DataTest().imageUriTest(R.drawable.user ))
        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (isUserMain){
            inflater.inflate(R.menu.menu_appbar_profile, menu)
        }else{
            inflater.inflate(R.menu.menu_profile_otheruser, menu)

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.ic_menus -> {
                mainActivity.clickBtnOpen()
            }
            R.id.ic_add_status -> {
                mainActivity.openAddPost()
            }
        }
        return true
    }

    companion object {
        @JvmStatic
        fun newInstance(isUserMain: Boolean, userName: String) = Fragment_profile().apply {
            arguments = Bundle().apply {
                putBoolean(ARG_IS_USER_MAIN, isUserMain)
                putString(ARG_IS_USER_OTHER, userName)

            }
        }

    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        init(view)
        setUser(user.UserName)
        dataArray()
        setProfile()
        setAdapter_status(listUser, container)
        setAdapter_users(listUser, container)
        addEvent(view, container)

        mainActivity.toolbar.title = user.UserName


        if (isUserMain){
            linearLayout_follow_messenger.visibility = View.GONE
            btn_editProfile.visibility = View.VISIBLE
            mainActivity.toolbar.navigationIcon = null
        }else{
            btn_editProfile.visibility = View.GONE
            linearLayout_follow_messenger.visibility = View.VISIBLE
            mainActivity.toolbar.navigationIcon = ContextCompat.getDrawable(mainActivity, R.drawable.ic_return)
            mainActivity.toolbar.setNavigationOnClickListener {
                parentFragmentManager.popBackStack()
            }

        }

        if (listStatus.size > 0){
            ll0status.visibility = View.GONE
            gv_listStatus.visibility = View.VISIBLE
        }else{
            ll0status.visibility = View.VISIBLE
            gv_listStatus.visibility = View.GONE
        }

        return view
    }

    private fun init(view: View?) {
        if (view != null){
            mainActivity = activity as HomePageActivity
            btn_editProfile = view.findViewById(R.id.btn_edit_Profile_User)
            img_showOtherUser = view.findViewById(R.id.img_showOtherUser)
            rv_otherUser = view.findViewById(R.id.rv_otherUser)
            gv_listStatus = view.findViewById(R.id.gv_listStatus)
            ll0status = view.findViewById(R.id.linearLayout_0status)
            btn_showAllOtherUser = view.findViewById(R.id.btn_showAllOtherUser_pofile)
            txt_showAllOtherUser = view.findViewById(R.id.txt_showAllOtherUser_profile)
            liearLayout_ohterUser_profile = view.findViewById(R.id.liearLayout_ohterUser_profile)
            linearLayout_followers  = view.findViewById( R.id.linearLayout_followers)
            linearLayout_followed  = view.findViewById( R.id.linearLayout_followed)
            linearLayout_follow_messenger  =  view.findViewById(R.id.linearLayout_follow_messenger)
            txt_name_profile = view.findViewById(R.id.txt_name_profile)
            txt_desc_profile = view.findViewById(R.id.txt_desc_profile)
            img_avt_profile  = view.findViewById(R.id.img_avt_profile)
            btn_follow = view.findViewById(R.id.btn_follow)
            btn_messenger = view.findViewById(R.id.btn_messenger)
        }
    }

    private fun setProfile() {
        txt_name_profile.setText("${user.FullName}")
        txt_desc_profile.setText("${user.Desc}")
        img_avt_profile.setImageURI(user.Avt)
    }

    private fun addEvent(view: View, container: ViewGroup?) {

        btn_follow.setOnClickListener {
            var colorBtn: Int = 0
            var colorText: Int = 0
            var bool: Boolean = true
            if(btn_follow.text.equals("Theo dõi")){ // lúc click mà nút đang ở trạng thái theo dõi thì thay đổi
                btn_follow.setText("Đang theo dõi")
                colorBtn = ContextCompat.getColor(container!!.context, R.color.greyish)
                colorText = ContextCompat.getColor(container.context, R.color.black)
                btn_follow.setBackgroundColor(colorBtn)
                btn_follow.setTextColor(colorText)
                bool = true // follow
            }else{
                btn_follow.setText("Theo dõi")
                colorBtn = ContextCompat.getColor(container!!.context, R.color.blue)
                colorText = ContextCompat.getColor(container.context, R.color.white)
                btn_follow.setBackgroundColor(colorBtn)
                btn_follow.setTextColor(colorText)
                bool = false // unFollow
            }
        }


        btn_editProfile.setOnClickListener {
            val i = Intent(activity, EditProfile_Activity::class.java)
            startActivity(i)
        }

        img_showOtherUser.setOnClickListener {
            if ( liearLayout_ohterUser_profile.visibility == View.VISIBLE ){
                img_showOtherUser.setImageResource(R.drawable.add_friend1)
                liearLayout_ohterUser_profile.visibility = View.GONE
            }else{
                img_showOtherUser.setImageResource(R.drawable.add_friend2)
                liearLayout_ohterUser_profile.visibility = View.VISIBLE
            }
        }
        txt_showAllOtherUser.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(
                container!!.id,
                Fragment_showAllOtherUser()
            ).addToBackStack("showOtherUser").commit()
        }
        btn_showAllOtherUser.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(
                container!!.id,
                Fragment_showAllOtherUser()
            ).addToBackStack("showOtherUser").commit()
        }

        linearLayout_followers.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(
                container!!.id,
                Fragment_showFollow()
            ).addToBackStack("showFollow").commit()
        }
        linearLayout_followed.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(
                container!!.id,
                Fragment_showFollow()
            ).addToBackStack("showFollow").commit()
        }
    }
    private fun setAdapter_status(array: ArrayList<User>, container: ViewGroup?){
        val listStatusChild = listStatus
        val customerAdapter_status_profile = CustomerAdapter_status_profile(container!!.context as FragmentActivity, listStatusChild, object : OnClickListent {
            override fun OnClickFollow(pos: Int, bool: Boolean) {
                TODO("Not yet implemented")
            }

            override fun OnClickClose(pos: Int) {
                TODO("Not yet implemented")
            }

            override fun OnClickView(pos: Int) {
                parentFragmentManager.beginTransaction().replace(container!!.id, Fragment_showStatus_User()).addToBackStack("showStatus").commit()
            }
        })
        gv_listStatus.adapter = customerAdapter_status_profile
    }
    private fun setAdapter_users(array: ArrayList<User>, container: ViewGroup?){
        val array2 = array
        val adt= CustomeRvAdapter_addFriend_profile(array2, object : OnClickListent {
            override fun OnClickFollow(pos: Int, bool: Boolean) {
                ///
            }

            override fun OnClickClose(pos: Int) {
            ///
            }

            override fun OnClickView(pos: Int) {
                parentFragmentManager.beginTransaction().replace(
                    container!!.id,
                    newInstance(false, array2[pos].UserName)
                ).addToBackStack("tag_${array2[pos].UserName}").commit()
            }
        })
        rv_otherUser.adapter = adt
        rv_otherUser.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
    }

    private fun dataArray(){
        listStatus.clear()
        listImages.clear()
        listUser.clear()

        listStatus.add(Status(0, "gyn", "no", Calendar.getInstance().time))
        listStatus.add(Status(1, "gyn", "hehe", Calendar.getInstance().time))
        listStatus.add(Status(2, "gyn", "ass2", Calendar.getInstance().time))
        listStatus.add(Status(3, "gyn", "ass2", Calendar.getInstance().time))
        listStatus.add(Status(4, "gyn", "ass2",Calendar.getInstance().time ))
        listStatus.add(Status(5, "gyn", "ass2", Calendar.getInstance().time ))

        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "gynhuyn", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "ha", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "ssss", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "saaa", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "aaaa", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "rrrrr", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", DataTest().imageUriTest(R.drawable.user ))))

    }

}