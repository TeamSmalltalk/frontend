package com.example.chating

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val mActionBar=supportActionBar
        mActionBar!!.hide()

        Handler().postDelayed({
            startActivity(Intent(this,ListActivity::class.java))
            finish()
        },2000)
    }
}