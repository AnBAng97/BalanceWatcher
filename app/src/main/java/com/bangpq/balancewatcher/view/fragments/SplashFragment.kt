package com.bangpq.balancewatcher.view.fragments

import android.util.Log
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import com.bangpq.balancewatcher.databinding.FragmentSplashBinding
import com.bangpq.balancewatcher.view.compose.SplashScreen
import com.bangpq.googlenews.presenter.viewmodel.SplashVM
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashVM>() {
    override fun closeApp() {
        TODO("Not yet implemented")
    }

    override fun showFragment(tag: Class<*>, screenTag: Class<*>, data: Any?, isBack: Boolean) {
        TODO("Not yet implemented")
    }
@Composable
    override fun initViews() {
        SplashScreen.Screen()
//        viewLifecycleOwner.lifecycleScope.launch {
//            mVModel.dataState.collectLatest {
//                if (it == null) return@collectLatest
////                updateUI(it)
//            }
//        }
//        lifecycleScope.launch {
//            mVModel.latest(("US"))
//        }
    }

    override fun initiateViewModel(): Class<SplashVM> {
        return SplashVM::class.java
    }

    override fun initiateViewBinding(container: ViewGroup?): FragmentSplashBinding {
return FragmentSplashBinding.inflate(layoutInflater,container,false)   }

    override fun handleSuccess(data: Any?, key: Int) {
        Log.i("handleSuccess", "key: $key")
        Log.i("handleSuccess", "data: $data")
    }
}