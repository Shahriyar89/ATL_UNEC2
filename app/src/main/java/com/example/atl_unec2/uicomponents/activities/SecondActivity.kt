package com.example.atl_unec2.uicomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.atl_unec2.R
import com.example.atl_unec2.databinding.ActivitySecondBinding
import com.example.atl_unec2.uicomponents.fragments.UserInfo

class SecondActivity : AppCompatActivity() {

    lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding= ActivitySecondBinding.inflate(layoutInflater)
//        val view= binding.root
//        setContentView(view)

         binding= DataBindingUtil.setContentView(
            this, R.layout.activity_second)

        val user= UserInfo("Ahmad","Mammadov", 25, visibility = true, image = "https://png.pngtree.com/png-vector/20190710/ourmid/pngtree-user-vector-avatar-png-image_1541962.jpg")

        binding.user=user
        binding.activity=this
    }


     fun showToast(){
         binding.title.text="Mammad"
    }
}