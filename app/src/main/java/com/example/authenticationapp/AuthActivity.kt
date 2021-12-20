package com.example.authenticationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.authenticationapp.login.LoginFragment

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        if(savedInstanceState ==null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance(), "login")
                .commit()

        }
    }
}