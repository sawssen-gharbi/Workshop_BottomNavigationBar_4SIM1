package com.example.workshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    lateinit var bottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(FragmentHome())
        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemHome -> loadFragment(FragmentHome())

                R.id.itemList -> loadFragment(FragmentListe())

                R.id.itemProfile -> loadFragment(FragmentProfile())


            }
            true
        }
    }


    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}