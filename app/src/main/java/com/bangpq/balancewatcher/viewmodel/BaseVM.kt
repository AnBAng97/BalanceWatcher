package com.bangpq.googlenews.presenter.viewmodel

import androidx.lifecycle.ViewModel
import com.bangpq.balancewatcher.viewmodel.state.UIState
import com.bangpq.googlenews.presenter.data.Constants
import com.bangpq.googlenews.presenter.data.Resource
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseVM<T : UIState<*>> : ViewModel() {
    var dataState: MutableStateFlow<T?> = MutableStateFlow(null)

    companion object {
        const val KEY_COMMON = -1
    }

    inline fun <reified U, V> handleState(
        accessDataState: MutableStateFlow<U?>,
        it: Resource<V>,
        isHandleSuccess: Boolean = false,
        key: Int = KEY_COMMON
    ) {
        val clazz = Class.forName(U::class.java.name)
        val state = clazz.newInstance() as UIState<V>
        state.code = it.code
        state.msg = it.msg
        state.key = key
        if (it is Resource.Success) {
            if (it.data == null) {
                state.code = Constants.CODE_NO_DATA
                accessDataState.value = state as U
                return
            }
            if (!isHandleSuccess) {
                handleSuccess(it, state, accessDataState, key)
            } else {
                accessDataState.value = state as U
            }
        } else {
            if (it is Resource.Loading) {
                state.code = Constants.CODE_LOADING
            } else if (it is Resource.Exception) {
                state.code = Constants.CODE_EXCEPTION
            }
            accessDataState.value = state as U
        }
    }

    open fun <V> handleSuccess(
        it: Resource.Success<*>,
        state: UIState<*>,
        accessDataState: MutableStateFlow<V?>,
        key: Int
    ){
        accessDataState.value = state as V
    }

}