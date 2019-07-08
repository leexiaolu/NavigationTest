package com.ouch.navigationtest.weight

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.ouch.navigationtest.R
import com.ouch.navigationtest.utils.ThreadUtils
import kotlinx.android.synthetic.main.layout_splash.*

/**
 * Created by 李小璐 on 2019-07-05.
 */
class SplashDialog(context: Context) : Dialog(context, android.R.style.Theme_NoTitleBar_Fullscreen) {

    private lateinit var anim: Animation

    init {
        setContentView(R.layout.layout_splash)

        ThreadUtils.postDelayOnUI(Runnable {
            Log.e("SplashDialog", "post")
            startAnim()
        }, 2000)
    }

    private fun startAnim() {
        anim = AnimationUtils.loadAnimation(context, R.anim.anim_splash)
        anim.isFillEnabled = true
        anim.fillAfter = true
        cl_splash.clearAnimation()
        cl_splash.animation = anim
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                Log.e("SplashDialog", "onAnimationEnd")
                if (!anim.hasEnded()) {
                    anim.cancel()
                }
                dismiss()
            }

            override fun onAnimationStart(animation: Animation?) {
                Log.e("SplashDialog", "onAnimationStart")
            }

        })
    }
}