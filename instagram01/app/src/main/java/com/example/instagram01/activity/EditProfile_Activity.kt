package com.example.instagram01.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.instagram01.R
import com.example.instagram01.model.User
import com.example.instagram01.reusable_classes.DataTest

class EditProfile_Activity : AppCompatActivity() {
    private var user: User = User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "rrrrr", "des", DataTest().imageUriTest(R.drawable.avt_test) )

    private lateinit var toolbar: Toolbar
    private lateinit var imgAvt: ImageView
    private lateinit var radioGroup: RadioGroup
    private lateinit var edt_fullName: EditText
    private lateinit var edt_userName: EditText
    private lateinit var edt_email: EditText
    private lateinit var edt_phoneNumber: EditText
    private lateinit var edt_bỉrthday: EditText
    private lateinit var edt_desc: EditText

    private fun init(){
        toolbar = findViewById(R.id.toolbar_editProfile)
        imgAvt = findViewById(R.id.img_avt)
        radioGroup = findViewById(R.id.radioGroup_sex)
        edt_fullName = findViewById(R.id.edt_fullName)
        edt_userName = findViewById(R.id.edt_userName)
        edt_email = findViewById(R.id.edt_email)
        edt_phoneNumber = findViewById(R.id.edt_phoneNumber)
        edt_bỉrthday = findViewById(R.id.edt_birthday)
        edt_desc = findViewById(R.id.edt_desc)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        init()
        setDataView()
        addEvent()
    }

    private fun setDataView() {
        imgAvt.setImageURI(user.Avt)
        edt_fullName.setText(user.FullName)
        edt_userName.setText(user.UserName)
        edt_email.setText(user.Email)
        edt_phoneNumber.setText("${user.PhoneNumber}")
        edt_bỉrthday.setText(user.Birthday)
        edt_desc.setText(user.Desc)
        if (user.Sex){
            radioGroup.check(R.id.radio_button_male)
        }else{
            radioGroup.check(R.id.radio_button_female)
        }
    }
    private fun getDataView(){
        user.Avt = DataTest().imageUriTest(R.drawable.avt_test) //
        user.FullName = edt_fullName.text.toString()
        user.UserName = edt_userName.text.toString()
        user.Email = edt_email.text.toString()
        user.PhoneNumber = edt_phoneNumber.text.toString().toShort()
        user.Desc = edt_desc.text.toString()
    }
    private fun addEvent() {
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.ic_save_profile -> {
                    getDataView()

                    // gửi dữ liệu lên data rồi quay lại activity_main
                    finish()
                }
            }
            true
        }
        toolbar.setNavigationOnClickListener {
            finish()
        }
        radioGroup.setOnCheckedChangeListener(object : OnCheckedChangeListener{
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
                when(p1){
                    R.id.radio_button_male -> {
                        user.Sex = true
                    }
                    R.id.radio_button_female -> {
                        user.Sex = false
                    }
                }
            }
        })


    }

}