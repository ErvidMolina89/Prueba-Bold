package com.example.mobile.pruebabold.di.module

import com.example.mobile.pruebabold.di.scope.ApplicationScope
import com.example.mobile.pruebabold.view.woeid.WoeidFragment
import com.example.mobile.pruebabold.view.woeid.WoeidViewModel
import dagger.Module
import dagger.Provides

@Module
class ModuleFragment {

    @ApplicationScope
    @Provides
    fun provideWoeidFragment() = WoeidFragment()
}