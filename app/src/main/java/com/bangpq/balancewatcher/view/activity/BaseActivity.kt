package com.bangpq.balancewatcher.view.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.bangpq.balancewatcher.R
import com.bangpq.googlenews.OnHomeCallBack
import com.bangpq.balancewatcher.view.fragments.BaseFragment

abstract class BaseActivity<B : ViewBinding, V : ViewModel> : AppCompatActivity(),
    View.OnClickListener,
    OnHomeCallBack {
    protected lateinit var mBind: B
    protected lateinit var mVModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBind = initiateViewBinding()
        mVModel = ViewModelProvider(this).get(initiateViewModel())
        setContentView(mBind.root)
        checkInternetPermission()
        initViews()
    }

    override fun onClick(v: View?) {
        v?.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in))
        clickView(v)
    }

    open fun clickView(v: View?) {
        //Do st
    }

    override fun closeApp() {
        finish()
    }

    override fun showFragment(tag: Class<*>, screenTag: Class<*>, data: Any?, isBack: Boolean) {
        val clazz = Class.forName(screenTag.name)
        val fragment = clazz.getConstructor().newInstance() as BaseFragment< *>
        fragment.mCallBack = this
        fragment.mData = data
        val tran = supportFragmentManager.beginTransaction()
        if (isBack) {
            tran.addToBackStack(tag.name)
        }
        tran.replace(R.id.ln_main, fragment, screenTag.name).commit()
    }

    @SuppressLint("NewApi")
    fun checkInternetPermission() {
        when (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.INTERNET)
        ) {
            PackageManager.PERMISSION_GRANTED -> {
                Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show()
            }
            else -> {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.INTERNET), 1)

            }
        }
    }

    abstract fun initiateViewModel(): Class<V>
    abstract fun initiateViewBinding(): B
    abstract fun initViews()
}