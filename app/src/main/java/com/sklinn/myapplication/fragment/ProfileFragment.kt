package com.sklinn.myapplication.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sklinn.myapplication.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_saveProfile.setOnClickListener {
            saveProfile()
        }
    }

    private fun saveProfile() {

        val userName = et_profileName.text.toString()
        val phone = et_phoneNumber.text.toString()
        val email = et_email.text.toString()

        val pref =  activity?.getSharedPreferences("my_profile", Context.MODE_PRIVATE)
        val prefEditor = pref?.edit()
        prefEditor?.putString("user_name",userName)
        prefEditor?.putString("user_phone",phone)
        prefEditor?.putString("user_email",email)
        prefEditor?.putBoolean("isLogged",true)
        prefEditor?.commit()
    }
}