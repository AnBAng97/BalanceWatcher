package com.bangpq.balancewatcher.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bangpq.balancewatcher.viewmodel.state.UIState
import com.bangpq.googlenews.OnHomeCallBack
import com.bangpq.googlenews.ProgressLoading
import com.bangpq.googlenews.notify
import com.bangpq.googlenews.presenter.data.Constants
import com.bangpq.googlenews.presenter.viewmodel.BaseVM

abstract class BaseFragment<V : BaseVM<*>> : Fragment(), View.OnClickListener, OnHomeCallBack {
    protected lateinit var mContext: Context
    protected lateinit var mBind: View
    protected lateinit var mVModel: V
    lateinit var mCallBack: OnHomeCallBack
    var mData: Any? = null

    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
    }

    override fun onClick(v: View?) {
        v?.startAnimation(
            AnimationUtils.loadAnimation(
                mContext,
                android.R.anim.fade_in
            )
        )
        clickView(v)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBind = ComposeView(requireContext()).apply {
            setContent {
                InitViews()
            } }
        mVModel = ViewModelProvider(this).get(initiateViewModel())
        return mBind
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    @Composable
    abstract fun InitViews()
    abstract fun initiateViewModel(): Class<V>
//    abstract fun initiateViewBinding(container: ViewGroup?): View

    open fun clickView(v: View?) {
        TODO("Not yet implemented")
    }

    protected open fun showError(msg: String?) {
        notify(msg ?: "Something went wrong!", requireContext())
    }

    protected open fun showLoading() {
        ProgressLoading.instance.show(context)
    }

    protected open fun hideLoading() {
        ProgressLoading.instance.dismiss()
    }

    protected inline fun <reified T : UIState<*>> updateUI(it: T) {
        when (it.code) {
            Constants.CODE_OK -> handleSuccess(it.data, it.key!!)
            Constants.CODE_LOADING -> {
                showLoading()
                return
            }
            Constants.CODE_EXCEPTION -> showError(it.msg)
            Constants.CODE_NO_DATA -> showError("No Data")
            else -> showError(it.msg)
        }
        hideLoading()
    }

    abstract fun handleSuccess(data: Any?, key: Int)

}