package com.example.mobile.pruebabold.di.module

import android.app.Application
import com.example.mobile.pruebabold.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ModuleApplication (val application: Application) {

    @ApplicationScope
    @Provides
    fun providesApplication() = application

    @ApplicationScope
    @Provides
    fun providesContext() = application.applicationContext

}