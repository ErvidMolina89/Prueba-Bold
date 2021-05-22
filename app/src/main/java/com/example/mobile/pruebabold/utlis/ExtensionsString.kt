package com.example.mobile.pruebabold.utlis

import android.util.Log

fun String.showInlog(tag: String = "Log", t: Throwable? = null) :String {
    Log.e(tag, this, t)
    return this
}