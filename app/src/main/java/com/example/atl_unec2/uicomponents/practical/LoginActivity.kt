package com.example.atl_unec2.uicomponents.practical

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.atl_unec2.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    companion object {
        const val USER_NAME = "ATL"
        const val PASSWORD = "UNEC"
    }

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkLogin()

    }


    private fun checkLogin() {
//        with(binding) {
//            val inputName = userName.text.toString()
//            val inputPassword = password.text.toString()
//            if (inputName == USER_NAME && inputPassword == PASSWORD) {
//                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
//                intent.also {
//                    it.putExtra("NAME", inputName)
//                    it.putExtra("PASSWORD", inputPassword)
//                }
//                startActivity(intent)
//            }
//        }
    }
}