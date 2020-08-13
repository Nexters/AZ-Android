package com.az.youtugo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.az.core.LoginStatus
import com.az.core.Preferences
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    private val sharedPrefs: Preferences by inject()

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
                        toolbar.onDestinationChanged(destination.id, sharedPrefs.getLoginStatus())
                    }
                }
    }

    private fun initToolbarHandler() {
        toolbar.alarmHandler = {
            navController.navigate(R.id.alarmFragment)
        }
        toolbar.myPageHandler = {
            navController.navigate(R.id.myPageFragment)
        }
        toolbar.backspaceHandler = {
            navController.navigateUp()
        }
        toolbar.closeHandler = {
            navController.popBackStack()
        }
        toolbar.signUpHandler = {
            navController.navigate(R.id.signupFragment)
        }
    }
}
