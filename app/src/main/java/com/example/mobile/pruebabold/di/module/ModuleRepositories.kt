package com.example.mobile.pruebabold.di.module

import com.example.mobile.pruebabold.data_source.data_access.woeid.WoeidRemoteDataSource
import com.example.mobile.pruebabold.data_source.repositories.RepoSearch
import com.example.mobile.pruebabold.data_source.repositories.RepoWoeid
import com.example.mobile.pruebabold.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ModuleRepositories {

    @ApplicationScope
    @Provides
    fun providesRepositoriesWoeid() = RepoWoeid()

    @ApplicationScope
    @Provides
    fun providesRepositoriesSearch() = RepoSearch()
}