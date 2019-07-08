package com.ouch.navigationtest.weight

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.ViewAnimationUtils
import androidx.constraintlayout.widget.ConstraintHelper
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * Created by 李小璐 on 2019-07-05.
 */
class CircularRevealHelper @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintHelper(context, attrs, defStyleAttr) {

    override fun updatePostLayout(container: ConstraintLayout) {
        super.updatePostLayout(container)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val views = getViews(container)
            Log.e("CircularRevealHelper", "views size = ${views.size}")
            for (view in views) {
                Log.e("CircularRevealHelper", "view = ${view.width}")
                val anim = ViewAnimationUtils.createCircularReveal(view, view.width / 2,
                    view.height / 2, 0f,
                    Math.hypot((view.height / 2).toDouble(), (view.width / 2).toDouble()).toFloat())
                anim.duration = 3000
                clearAnimation()
                anim.start()
            }
        }
    }
}