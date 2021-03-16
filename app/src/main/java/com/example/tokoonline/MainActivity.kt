package com.example.tokoonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.tokoonline.activity.LoginActivity
import com.example.tokoonline.fragment.AkunFragment
import com.example.tokoonline.fragment.HomeFragment
import com.example.tokoonline.fragment.KeranjangFragment
import com.example.tokoonline.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.math.log

class MainActivity : AppCompatActivity() {

   private val fragmentHome: Fragment = HomeFragment() //asign java fragment 1 persatu
   private val fragmentAkun: Fragment = AkunFragment()
   private val fragmentKerjanjang: Fragment = KeranjangFragment()
   private val fm: FragmentManager = supportFragmentManager // untuk manager klik
   private var active: Fragment = fragmentHome // default menu active

    //menu ceklis
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    //cek login
    private var statusLogin = false
    private lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        s = SharedPref(this)

        setUpButtonNav()
    }
    fun setUpButtonNav(){
        //fm /fragment menager adalah untuk memanggil ketika dibutuhkan dan dimasukan kedalam if/when
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentAkun).hide(fragmentAkun).commit()
        fm.beginTransaction().add(R.id.container, fragmentKerjanjang).hide(fragmentKerjanjang).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0) //menu ceklis acvtive
        menuItem.isChecked = true //menu ceklis acvtive = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when(item.itemId){
                R.id.navigation_home ->{ // ketika navigation home diklik
                    callFragment(0,fragmentHome)
                }
                R.id.navigation_keranjang ->{
                    callFragment(1,fragmentKerjanjang)
                }
                R.id.navigation_akun ->{
                    if (s.getStatusLogin()){
                        callFragment(2,fragmentAkun)
                    }else{
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }
            }

            false
        }
    }

    fun callFragment(actMenu: Int, fragment: Fragment){
//        Log.d("Response","Akun")
        menuItem = menu.getItem(actMenu)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit() //menampikan menu yang diinginkan
        active = fragment
    }
}