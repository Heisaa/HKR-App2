package com.example.hkr_app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import com.example.hkr_app2.fragments.ContactFragment
import com.example.hkr_app2.fragments.IntroFragment
import com.example.hkr_app2.fragments.SkillsFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        val introFragment = IntroFragment()
        val skillsFragment = SkillsFragment()
        val contactFragment = ContactFragment()

        bottomNav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_intro -> {

                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace(R.id.fragmentContainerRight, introFragment)
                    }

                    true
                }
                R.id.page_skills -> {

                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace(R.id.fragmentContainerRight, skillsFragment)
                    }

                    true
                }
                R.id.page_contact -> {

                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace(R.id.fragmentContainerRight, contactFragment)
                    }

                    true
                }

                else -> false
            }
        }


    }
}