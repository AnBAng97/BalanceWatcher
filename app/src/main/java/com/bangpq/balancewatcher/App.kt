package com.bangpq.googlenews

import android.app.Application

class App : Application() {
    public val instance: App = this
    override fun onCreate() {
        super.onCreate()
    }

}