package com.example.mobile.pruebabold.di.module

import com.example.mobile.pruebabold.di.scope.ApplicationScope
import com.example.mobile.pruebabold.view.weather.SearchViewModel
import com.example.mobile.pruebabold.view.woeid.WoeidViewModel
import dagger.Module
import dagger.Provides

@Module
class ModuleViewModels {

    @ApplicationScope
    @Provides
    fun provideWoeidViewModel() = WoeidViewModel()

    @ApplicationScope
    @Provides
    fun provideSearchViewModel() = SearchViewModel()
}