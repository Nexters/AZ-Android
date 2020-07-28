package com.az.youtugo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        initNavigation()
        initToolbarHandler()
    }


    private fun initNavigation() {
        navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
                .findNavController()
                .apply {
                    addOnDestinationChangedListener { _, destination, _ ->
                        toolbar.onDestinationChanged(destination.id, null)
                    }
                }
    }

    private fun initToolbarHandler() {
        toolbar.myPageHandler = {
            navController.navigate(R.id.myPageFragment)
        }
        toolbar.backspaceHandler = {
            navController.popBackStack()
        }
    }
}
