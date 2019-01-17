package com.example.qwe2r.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(R.id.activity_fragment_container, NavigationFragment().apply {
                    openBaseNavigation().openBaseNavigation().openBaseNavigation().openBaseNavigation()
                })
                .commit()
    }
}
