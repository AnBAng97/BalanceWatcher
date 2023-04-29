package com.bangpq.googlenews.presenter.data

sealed class Resource<T>(
    val data: T? = null,
    val error: Any? = null,
    val code: Int? = null,
    val msg: String? = null
) {
    class Loading<T> : Resource<T>(code = Constants.CODE_LOADING)
    class Success<T>(data: T?) : Resource<T>(data, code = Constants.CODE_OK)
    class Failed<T, E>(error: E?, code: Int) :
        Resource<T>(error = error, code = code, msg = error?.toString())

    class Exception<T>(error: Throwable) :
        Resource<T>(error = error, code = Constants.CODE_EXCEPTION, msg = error.message)
}