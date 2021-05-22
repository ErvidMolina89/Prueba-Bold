package com.example.mobile.pruebabold.base

import android.app.Application
import android.content.Context
import com.example.mobile.pruebabold.di.component.ComponentApplication
import com.example.mobile.pruebabold.di.component.DaggerComponentApplication
import com.example.mobile.pruebabold.di.module.ModuleApplication

class App : Application() {

    private var componentApplication: ComponentApplication? = null

    override fun onCreate() {
        super.onCreate()
        context = this
        startComponentDagger()
    }

    // ------------- Methods Private-------------
    // Inicializamos los modulos de dagger
    private fun startComponentDagger(){
        componentApplication = DaggerComponentApplication
            .builder()
            .moduleApplication(ModuleApplication(this))
            .build()
    }

    fun getComponentApplication() = componentApplication

    companion object {
        private var context: Context? = null

        fun getContext() = context
    }
}