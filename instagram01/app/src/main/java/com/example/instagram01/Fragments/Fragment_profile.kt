package com.example.instagram01.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram01.R
import com.example.instagram01.adapters.CustomeRvAdapter_addFriend_profile
import com.example.instagram01.adapters.CustomeRvAdapter_status_profile
import com.example.instagram01.interfaceFun.RvInterface
import com.example.instagram01.model.ImageStaus
import com.example.instagram01.model.Status
import com.example.instagram01.model.User

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_profile.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_profile : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var listStatus:ArrayList<Status> = ArrayList()
    private var listImages: ArrayList<ImageStaus> = ArrayList()
    private var listUser: ArrayList<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_profile, container, false)


        dataArray()
        setDataGridView_status(view)
        setDataRecyclerView_friend(view, listUser)


        return view
    }


    private fun setDataGridView_status(view: View){
        var adt = activity?.let { CustomeRvAdapter_status_profile(it, listStatus, listImages) }
        var gv_listStatus = view.findViewById<GridView>(R.id.gv_listStatus)
        gv_listStatus.adapter = adt
    }
    private fun setDataRecyclerView_friend(view: View, array: ArrayList<User> ){
        val adt = CustomeRvAdapter_addFriend_profile(array, object : RvInterface{
            override fun OnClickFollow(pos: Int) {
                Toast.makeText(activity,"hehehe", Toast.LENGTH_SHORT).show()
            }

        })
        val rv_otherUser = view.findViewById<RecyclerView>(R.id.rv_otherUser)
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

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment_profile.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_profile().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}