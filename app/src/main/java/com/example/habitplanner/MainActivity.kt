package com.example.habitplanner

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.habitplanner.fragment.AddHabitFragment
import com.example.habitplanner.fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("CicloDeVida", "MainActivity - onCreate")
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        trocarFragment(HomeFragment())

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    trocarFragment(HomeFragment())
                    true
                }
                R.id.nav_add -> {
                    trocarFragment(AddHabitFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun trocarFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }

    override fun onStart() {
        super.onStart()
        Log.d("CicloDeVida", "MainActivity - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CicloDeVida", "MainActivity - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CicloDeVida", "MainActivity - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CicloDeVida", "MainActivity - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CicloDeVida", "MainActivity - onDestroy")
    }
}
