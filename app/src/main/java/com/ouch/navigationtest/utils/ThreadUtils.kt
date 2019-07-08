package com.ouch.navigationtest.utils

import android.os.Handler
import android.os.Looper

/**
 * Created by 李小璐 on 2019-07-04.
 */
class ThreadUtils {

    companion object {

        private val UI_HANDLER = Handler(Looper.getMainLooper())

        fun postOnUI(r: Runnable) {
            if (isMainThread()) {
                r.run()
            } else {
                UI_HANDLER.post(r)
            }
        }

        fun postDelayOnUI(r: Runnable, delayMillis: Long) {
            UI_HANDLER.postDelayed(r, delayMillis)
        }

        private fun isMainThread(): Boolean {
            return Looper.getMainLooper() == Looper.myLooper()
        }
    }

}