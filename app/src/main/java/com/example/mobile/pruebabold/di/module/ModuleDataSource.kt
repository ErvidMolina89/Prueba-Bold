package com.example.mobile.pruebabold.di.module

import com.example.mobile.pruebabold.data_source.data_access.search.SearchRemoteDataSource
import com.example.mobile.pruebabold.data_source.data_access.woeid.WoeidRemoteDataSource
import com.example.mobile.pruebabold.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ModuleDataSource {

    @ApplicationScope
    @Provides
    fun providesWoeidRemoteDataSource() = WoeidRemoteDataSource()

    @ApplicationScope
    @Provides
    fun providesSearchRemoteDataSource() = SearchRemoteDataSource()
}