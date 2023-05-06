package com.bangpq.balancewatcher.view.activity

import android.os.Build
import androidx.annotation.RequiresApi
import com.bangpq.balancewatcher.databinding.ActivityMainBinding
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
        showFragment(MainActivity::class.java, SplashFragment::class.java, null, false)
    }


}