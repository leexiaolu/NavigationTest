package com.ouch.navigationtest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.ouch.navigationtest.R
import com.ouch.navigationtest.weight.SplashDialog

class MainActivity : AppCompatActivity() {

    private lateinit var splashDialog: SplashDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        splashDialog = SplashDialog(this)
        splashDialog.show()

    }

    override fun onSupportNavigateUp() = Navigation.findNavController(this, R.id.fg_main).navigateUp()
}
