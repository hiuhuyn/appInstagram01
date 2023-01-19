package com.example.instagram01.Fragments.profile.child_profile

import android.os.Bundle
import android.view.*
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram01.Fragments.profile.Fragment_profile
import com.example.instagram01.R
import com.example.instagram01.activity.MainActivity
import com.example.instagram01.adapters.CustomeRvAdapter_addFriend_profile
import com.example.instagram01.interfaceFun.OnClickListent
import com.example.instagram01.model.ImageStaus
import com.example.instagram01.model.Status
import com.example.instagram01.model.User


class Fragment_showAllOtherUser : Fragment() {
    private lateinit var mainActivity: MainActivity
    private lateinit var recyclerView: RecyclerView
    private var listUser: ArrayList<User> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPause() {
        listUser.clear()
        mainActivity.toolbar.title = ""
        mainActivity.toolbar.navigationIcon = null
        super.onPause()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_show_all_other_user, container, false)
        mainActivity = activity as MainActivity
        mainActivity.toolbar.navigationIcon = ContextCompat.getDrawable(mainActivity, R.drawable.ic_return)
        mainActivity.toolbar.title = "Khám phá mọi người"
        mainActivity.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
        recyclerView = view.findViewById(R.id.rv_showAllUser)
        dataArray()
        recyclerView.adapter = CustomeRvAdapter_addFriend_profile(listUser, object : OnClickListent{
            override fun OnClickFollow(pos: Int, bool: Boolean) {
                //
            }

            override fun OnClickClose(pos: Int) {
                //
            }

            override fun OnClickView(pos: Int) {
                parentFragmentManager.beginTransaction().replace(
                    container!!.id,
                    Fragment_profile.newInstance(false, listUser[pos])
                ).addToBackStack("tag_${listUser[pos].UserName}").commit()
            }
        })
        recyclerView.layoutManager = GridLayoutManager(
            mainActivity, 2
        )



        addEvent(view)
        return view
    }

    private fun addEvent(view: View) {

    }
    private fun dataArray(){
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "gynhuyn", "des", R.drawable.user )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "ha", "des", R.drawable.add )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "ssss", "des", R.drawable.ic_launcher_background )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "saaa", "des", androidx.appcompat.R.drawable.abc_ic_ab_back_material )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "aaaa", "des", R.drawable.home )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "rrrrr", "des", R.drawable.avt_test )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", R.drawable.profile_icon )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", R.drawable.avt_test)))
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            Fragment_showAllOtherUser().apply {
                arguments = Bundle().apply {

                }
            }
    }
}