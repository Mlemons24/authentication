package com.codingwithmatt.authenticationapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codingwithmatt.authenticationapp.login.LoginFragment

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance(), "login")
                .commit()

        }
    }
}