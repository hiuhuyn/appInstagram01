package com.example.instagram01.Fragments.profile

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram01.Fragments.follow.Fragment_showFollow
import com.example.instagram01.Fragments.home.Fragment_home
import com.example.instagram01.Fragments.profile.child_profile.Fragment_showAllOtherUser
import com.example.instagram01.Fragments.status.Fragment_showStatus_User
import com.example.instagram01.R
import com.example.instagram01.activity.EditProfile_Activity
import com.example.instagram01.activity.MainActivity
import com.example.instagram01.adapters.CustomeRvAdapter_addFriend_profile
import com.example.instagram01.adapters.CustomeRvAdapter_status_profile
import com.example.instagram01.interfaceFun.OnClickListent
import com.example.instagram01.model.ImageStaus
import com.example.instagram01.model.Status
import com.example.instagram01.model.User
import java.time.LocalDate


private const val ARG_IS_USER_MAIN = "isusermain"
private const val ARG_IS_USER_OTHER = "userother"


class Fragment_profile : Fragment() {
    private lateinit var mainActivity: MainActivity

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


    private var isUserMain: Boolean = false
    private var user: User = User()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            isUserMain = it.getBoolean(ARG_IS_USER_MAIN)
            user = it.getSerializable(ARG_IS_USER_OTHER) as User

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (isUserMain){
            inflater.inflate(R.menu.menu_appbar_profile, menu)
        }else{
            inflater.inflate(R.menu.menu_profile_otheruser, menu)

        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        @JvmStatic
        fun newInstance(isUserMain: Boolean, user: User) = Fragment_profile().apply {
            arguments = Bundle().apply {
                putBoolean(ARG_IS_USER_MAIN, isUserMain)
                putSerializable(ARG_IS_USER_OTHER, user)

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

        mainActivity = activity as MainActivity
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

        mainActivity.toolbar.title = "gyn.huyn"


        mainActivity.toolbar.navigationIcon = null
        mainActivity.toolbar.title = user.UserName

        if (isUserMain){
            linearLayout_follow_messenger.visibility = View.GONE
            btn_editProfile.visibility = View.VISIBLE
        }else{
            btn_editProfile.visibility = View.GONE
            linearLayout_follow_messenger.visibility = View.VISIBLE
            mainActivity.toolbar.navigationIcon = ContextCompat.getDrawable(mainActivity, R.drawable.ic_return)
            mainActivity.toolbar.setNavigationOnClickListener {
                parentFragmentManager.popBackStack()
            }

        }

        setProfile()

        dataArray()
        setAdapter_status(view, listUser, container)
        setAdapter_users(view, listUser, container)
        addEvent(view, container)




        if (listStatus.size > 0){
            ll0status.visibility = View.GONE
            gv_listStatus.visibility = View.VISIBLE
        }else{
            ll0status.visibility = View.VISIBLE
            gv_listStatus.visibility = View.GONE
        }
        return view
    }

    private fun setProfile() {
        txt_name_profile.setText("${user.FullName}")
        txt_desc_profile.setText("${user.Desc}")
        img_avt_profile.setImageResource(user.Avt)
    }

    private fun addEvent(view: View, container: ViewGroup?) {

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
    private fun setAdapter_status(view: View, array: ArrayList<User>, container: ViewGroup?){
        val listStatusChild = listStatus


        val customeRvAdapter_status_profile = activity?.let { CustomeRvAdapter_status_profile(it, listStatusChild, listImages, object : OnClickListent {
            override fun OnClickFollow(pos: Int, bool: Boolean) {
                TODO("Not yet implemented")
            }

            override fun OnClickClose(pos: Int) {
                TODO("Not yet implemented")
            }

            override fun OnClickView(pos: Int) {
                parentFragmentManager.beginTransaction().replace(container!!.id, Fragment_showStatus_User()).addToBackStack("showStatus").commit()
            }
        }) }
        gv_listStatus.adapter = customeRvAdapter_status_profile
    }


    private fun setAdapter_users(view: View, array: ArrayList<User>, container: ViewGroup?){
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
                    newInstance(false, array2[pos])
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
        listStatus.add(Status(0, "gyn", "no"))
        listStatus.add(Status(1, "gyn", "hehe" ))
        listStatus.add(Status(2, "gyn", "ass2" ))
        listStatus.add(Status(3, "gyn", "ass2" ))


        listImages.add(ImageStaus(0, 0, R.drawable.ic_launcher_background))
        listImages.add(ImageStaus(1, 0, R.drawable.ic_launcher_background))
        listImages.add(ImageStaus(2, 1, R.drawable.ic_launcher_background))
        listImages.add(ImageStaus(3, 2, R.drawable.ic_launcher_background))
        listImages.add(ImageStaus(4, 2, R.drawable.ic_launcher_background))
        listImages.add(ImageStaus(5, 3, R.drawable.ic_launcher_background))

        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "gynhuyn", "des", R.drawable.user )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "ha", "des", R.drawable.add )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "ssss", "des", R.drawable.ic_launcher_background )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "saaa", "des", androidx.appcompat.R.drawable.abc_ic_ab_back_material )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "aaaa", "des", R.drawable.home )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "rrrrr", "des", R.drawable.avt_test )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", R.drawable.profile_icon )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", R.drawable.avt_test)))

    }

}