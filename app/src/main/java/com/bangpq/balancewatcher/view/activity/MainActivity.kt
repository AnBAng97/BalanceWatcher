package com.bangpq.balancewatcher.view.activity

import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.bangpq.balancewatcher.databinding.ActivityMainBinding
import com.bangpq.balancewatcher.view.compose.navigation.RootNavigation
import com.bangpq.balancewatcher.view.fragments.SplashFragment
import com.bangpq.googlenews.presenter.viewmodel.MainVM

class MainActivity : BaseActivity<ActivityMainBinding, MainVM>() {
    override fun initiateViewModel(): Class<MainVM> {
        return MainVM::class.java
    }

    override fun initiateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }


    override fun initViews() {
//        showFragment(MainActivity::class.java, SplashFragment::class.java, null, false)
        setContent {
            val navController = rememberNavController()
            RootNavigation(navController = navController)
        }
    }


}