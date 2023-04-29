package com.bangpq.balancewatcher.viewmodel.state

open class UIState<T> {
    var code : Int? = 0
    var key: Int? = 0
    var data: T? = null
    var msg: String? = null
}