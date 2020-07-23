package com.az.youtugo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: DynamicToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        initBottomNavigation()

        // 핸들러를 달아서 어떤 fragment를 보여줄 지 정의
        toolbar.myPageHandler = {
            myPage()
        }
    }

    // navController를 사용해서 화면 이동
    private fun myPage() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.findNavController()
        navController.addOnDestinationChangedListener { _, destination, _ ->
            toolbar.onDestinationChanged(destination.id, null)
        }
        navController.navigate(R.id.myPageFragment)

    }

    // TODO 제거 예정 (바텀 네비게이션 사용하지 않음)
    private fun initBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.findNavController()

        bottomNavigation.setupWithNavController(navController = navController)
    }
}
