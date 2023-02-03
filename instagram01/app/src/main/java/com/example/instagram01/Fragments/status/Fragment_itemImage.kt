package com.example.instagram01.Fragments.status

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.instagram01.R


private const val ARG_IMAGE = "image"



class Fragment_itemImage : Fragment() {
    private var image: Int = R.drawable.avt_test

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            image = it.getInt(ARG_IMAGE)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.item_image, container, false)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(image)
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(image: Int) =
            Fragment_itemImage().apply {
                arguments = Bundle().apply {
                    putInt(ARG_IMAGE, image)
                }
            }
    }
}