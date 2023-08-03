package com.example.splashscreenanimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val backgroundIMG:ImageView = findViewById(R.id.imageView_id)
        val slideAnimation = AnimationUtils.loadAnimation(this,R.anim.slide)
        backgroundIMG.startAnimation(slideAnimation)

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },300)
    }
}