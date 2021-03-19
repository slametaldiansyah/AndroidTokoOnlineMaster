package com.example.tokoonline.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tokoonline.R
import com.example.tokoonline.app.ApiConfig
import kotlinx.android.synthetic.main.activity_register.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            register()
        }
    }

    fun register(){
        if (edt_nama.text.isEmpty())
        {
            edt_nama.error = "Kolom Nama Tidak Boleh Kosong"
            edt_nama.requestFocus()
            return
        } else if(edt_email.text.isEmpty())
        {
            edt_email.error = "Kolom Email Tidak Boleh Kosong"
            edt_email.requestFocus()
            return
        }else if (edt_phone.text.isEmpty())
        {
            edt_phone.error = "Kolom Phone Tidak Boleh Kosong"
            edt_phone.requestFocus()
            return
        }else if (edt_password.text.isEmpty())
        {
            edt_password.error = "Kolom Password Tidak Boleh Kosong"
            edt_password.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.register(edt_nama.text.toString(),edt_email.text.toString(),edt_password.text.toString()).enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                // handle ketika success
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                // handle ketika gagal
            }

        })

    }
}