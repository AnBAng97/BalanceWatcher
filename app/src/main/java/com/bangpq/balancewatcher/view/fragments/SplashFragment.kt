package com.bangpq.balancewatcher.view.fragments

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.bangpq.balancewatcher.view.compose.navigation.RootNavigation
import com.bangpq.googlenews.presenter.viewmodel.SplashVM

class SplashFragment : BaseFragment<SplashVM>() {
    override fun closeApp() {
        TODO("Not yet implemented")
    }

    override fun showFragment(tag: Class<*>, screenTag: Class<*>, data: Any?, isBack: Boolean) {
        TODO("Not yet implemented")
    }

    @Composable
    override fun InitViews() {
        val navController = rememberNavController()
        RootNavigation(
            navController = navController
        )
    }


    override fun initiateViewModel(): Class<SplashVM> {
        return SplashVM::class.java
    }

    override fun handleSuccess(data: Any?, key: Int) {
        Log.i("handleSuccess", "key: $key")
        Log.i("handleSuccess", "data: $data")
    }
}