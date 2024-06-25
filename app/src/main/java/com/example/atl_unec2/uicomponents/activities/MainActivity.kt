package com.example.atl_unec2.uicomponents.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.atl_unec2.R
import com.example.atl_unec2.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("ActivityLifeCircle => ", "onCreate")
        val button = findViewById<Button>(R.id.btnNext)

        button.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
//            intent.putExtra("USER_NAME", 10)

            val b = Bundle()
            b.putBoolean("IsOpened", true)

            val bundle2 = bundleOf()
            bundle2.putInt("Year", 2024)

            val bundle3 = bundleOf(
                "BirghDate" to "12.12.1999"
            )
            intent.putExtras(bundle3)
            intent.also {
                it.putExtras(bundle2)
            }

            intent.also {
                it.putExtra(USER_NAME, "AHMAD")
                it.putExtra(USER_AGE, 10)
            }
            startActivity(intent)

           finish()
        }


    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifeCircle => ", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifeCircle => ", "onResume")
    }

    //Ekranim gorunur

    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifeCircle => ", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifeCircle => ", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ActivityLifeCircle => ", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityLifeCircle => ", "onDestroy")
    }


    companion object {
        const val USER_NAME = "USER_NAME"
        const val USER_AGE = "userAge"
    }
}