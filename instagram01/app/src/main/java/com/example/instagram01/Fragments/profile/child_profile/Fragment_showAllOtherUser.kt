package com.example.instagram01.Fragments.profile.child_profile

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram01.Fragments.profile.Fragment_profile
import com.example.instagram01.R
import com.example.instagram01.activity.HomePageActivity
import com.example.instagram01.adapters.CustomeRvAdapter_addFriend_profile
import com.example.instagram01.interfaceFun.OnClickListent
import com.example.instagram01.model.User
import com.example.instagram01.reusable_classes.DataTest


class Fragment_showAllOtherUser : Fragment() {
    private lateinit var mainActivity: HomePageActivity
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
        mainActivity = activity as HomePageActivity
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
                    Fragment_profile.newInstance(false, listUser[pos].UserName)
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
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "gynhuyn", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "ha", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "ssss", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "saaa", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "aaaa", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "rrrrr", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des",DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", DataTest().imageUriTest(R.drawable.user ))))
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