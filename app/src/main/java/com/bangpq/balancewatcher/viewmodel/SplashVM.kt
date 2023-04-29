package com.bangpq.googlenews.presenter.viewmodel

import com.bangpq.balancewatcher.viewmodel.state.UIState
import com.bangpq.googlenews.presenter.data.API
import com.bangpq.googlenews.presenter.data.NewsDto
import com.bangpq.googlenews.presenter.data.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SplashVM : BaseVM<UIState<NewsDto>>() {
    suspend fun latest(country: String) = flow {
        try {
            emit(Resource.Loading())
            val rs = API.getAPI().latest(country)
            emit(Resource.Success(rs))
        } catch (e: Exception) {
            emit(Resource.Exception(e))
            e.printStackTrace()
        }
    }.onEach {
        handleState(dataState, it)
    }.launchIn(CoroutineScope(Dispatchers.IO))
}