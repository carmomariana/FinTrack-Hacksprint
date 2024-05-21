package com.example.fintrack


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            // Finaliza a exibição da tela de Splash
            finish()

            // Inicia a Activity de Login
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000 )
    }

}