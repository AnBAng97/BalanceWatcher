package com.bangpq.googlenews

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.view.WindowManager
import android.widget.Toast

const val PREF_FILE = "pref_saving"

enum class Event {
    OK_BUTTON, CANCEL_BUTTON
}

fun Context.getPref(key: String): String? {
    val pref: SharedPreferences =
        getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)
    return pref.getString(key, null)
}

fun Context.savePref(key: String,value:String)  {
        getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)
            .edit().putString(key, value).apply()
}

fun Context.clearPref(key: String) {
    val pref: SharedPreferences =
        getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)
    pref.edit().remove(key).apply()
}

fun Context.isInternetAvailable(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val ni = cm.activeNetworkInfo
    return ni != null && ni.isConnectedOrConnecting
}

fun notify(sms: String, context: Context) {
    Toast.makeText(context, sms, Toast.LENGTH_SHORT).show()
}

fun alert(
    context: Context,
    title: String = "Alert",
    msg: String,
    txtOK: String = "OK",
    txtCancel: String = "Cancel",
    event: (Event) -> Unit
) {
    val alert = AlertDialog.Builder(context).create()
    alert.setTitle(title)
    alert.setMessage(msg)
    alert.setButton(AlertDialog.BUTTON_POSITIVE, txtOK) { _, _ -> event(Event.CANCEL_BUTTON) }

    alert.show()
}

fun Dialog.doKeepDialog() {
    if (window == null) return
    val lp = WindowManager.LayoutParams()
    lp.copyFrom(window!!.attributes)
    lp.width = WindowManager.LayoutParams.MATCH_PARENT
    lp.height = WindowManager.LayoutParams.MATCH_PARENT
    window!!.attributes = lp
}