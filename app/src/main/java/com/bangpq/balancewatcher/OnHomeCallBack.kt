package com.bangpq.googlenews

interface OnHomeCallBack {
    fun closeApp()
    fun showFragment(tag: Class<*>, screenTag: Class<*>, data: Any? = null, isBack: Boolean = false)
}