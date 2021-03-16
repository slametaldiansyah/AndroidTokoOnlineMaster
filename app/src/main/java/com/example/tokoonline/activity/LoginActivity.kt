package com.example.tokoonline.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tokoonline.R
import com.example.tokoonline.helper.SharedPref

class LoginActivity : AppCompatActivity() {

    lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn_login:Button = findViewById(R.id.btn_prosesLogin)
        var btn_daftar:Button = findViewById(R.id.btn_darftar)
        s = SharedPref(this)

        btn_login.setOnClickListener {
            s.setStatusLogin(true)
        }
    }
}