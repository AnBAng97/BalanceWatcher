package com.bangpq.googlenews

import android.app.Dialog
import android.content.Context
import android.os.Handler
import android.view.Gravity
import android.view.Window
import com.bangpq.balancewatcher.R

class ProgressLoading {
    private val isLoading: Boolean
        get() = pdLoading != null && pdLoading!!.isShowing
    private var pdLoading: Dialog? = null
    private var isHide = false

    companion object {
        val instance: ProgressLoading = ProgressLoading()
    }

    fun donShow() {
        isHide = true
    }

    fun show(context: Context?) {
        if (!isLoading && context != null && !isHide) {
            try {
                if (pdLoading == null) {
                    pdLoading = Dialog(context, android.R.style.Theme_DeviceDefault_Dialog)
                    pdLoading?.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    pdLoading?.setContentView(R.layout.progress_loading)
                    pdLoading!!.setCanceledOnTouchOutside(false)
                    pdLoading!!.window!!.setGravity(Gravity.CENTER)
                    pdLoading!!.setCancelable(false)
                }
                pdLoading!!.show()
//                pdLoading!!.doKeepDialog()
            } catch (ignored: Exception) {

            }
            isHide = false
        }
    }

    fun dismiss() {
        if (pdLoading != null && pdLoading!!.isShowing) {
            Handler().postDelayed({
                try {
                    if (pdLoading != null && pdLoading!!.isShowing) {
                        pdLoading!!.dismiss()
                        pdLoading = null
                    }
                } catch (ignored: Exception) {
//                    ignored.printStackTrace()
                }
            }, 800)
        }
    }
}

