package com.example.atl_unec.animation

import android.R
import android.animation.ObjectAnimator
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.VelocityTracker
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.example.atl_unec2.databinding.ActivityAnimationBinding


class AnimationActivity : AppCompatActivity() {

    lateinit var binding: ActivityAnimationBinding
    private var velocityTracker: VelocityTracker? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.imageView1.setBackgroundResource(com.example.atl_unec2.R.drawable.animation_list)
        val animationDrawable = binding.imageView1.background as AnimationDrawable
        binding.imageView1.post {
            animationDrawable.start()
        }



        // Get the screen width
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenWidth = displayMetrics.widthPixels.toFloat()

        // Create and start the animation
        val animator = ObjectAnimator.ofFloat(binding.textview, "translationX", 0f, screenWidth)
        animator.duration = 2000 // Animation duration in milliseconds
        animator.start()






//        val anim: Animation =
//            AnimationUtils.loadAnimation(this, R.anim.)
//        anim.interpolator = LinearInterpolator() // for smooth animation







//
        val view= binding.imageView2

        // Setting up a spring animation to animate the view
//        val animation = SpringAnimation(view, DynamicAnimation.TRANSLATION_Y, 0f)
//
//
//        // Setting the damping ratio to create a high bouncing effect
//        animation.spring.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY)
//
//
//        // Setting the spring with a very low stiffness
//        animation.spring.setStiffness(SpringForce.STIFFNESS_VERY_LOW)
//
//
//        // Registering the AnimationEnd listener
//        // This will indicate the End of the animation
//        animation.addEndListener { animation1, canceled, value, velocity -> // set the image to the beginning of the Y axis
//            view.y = 50f
//
//
//            // Again starting the animation
//            animation.animateToFinalPosition(100f)
//        }


        // setting a OnClickListener to the view
        // Starts the animation when the image is clicked
//        view.setOnClickListener {
//                // starts the animation
//
//                animation.animateToFinalPosition(100f)
//            }
        }

    }