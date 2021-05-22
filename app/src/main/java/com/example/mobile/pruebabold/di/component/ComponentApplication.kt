package com.example.mobile.pruebabold.di.component

import com.example.mobile.pruebabold.data_source.data_access.woeid.WoeidRemoteDataSource
import com.example.mobile.pruebabold.di.module.ModuleApplication
import com.example.mobile.pruebabold.di.module.RetrofitModule
import dagger.Component

@Component(modules = [ModuleApplication::class, RetrofitModule::class])
interface ComponentApplication {

    //DataSource
    fun inject(woeidRemoteDataSource: WoeidRemoteDataSource)
}