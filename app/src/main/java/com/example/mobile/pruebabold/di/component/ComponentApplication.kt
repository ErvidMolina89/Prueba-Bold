package com.example.mobile.pruebabold.di.component

import com.example.mobile.pruebabold.MainActivity
import com.example.mobile.pruebabold.data_source.data_access.search.SearchRemoteDataSource
import com.example.mobile.pruebabold.data_source.data_access.woeid.WoeidRemoteDataSource
import com.example.mobile.pruebabold.data_source.repositories.RepoSearch
import com.example.mobile.pruebabold.data_source.repositories.RepoWoeid
import com.example.mobile.pruebabold.di.module.*
import com.example.mobile.pruebabold.uses_case.search_case.ConsulteForSearchUseCase
import com.example.mobile.pruebabold.uses_case.woeid_case.ConsulteForWoeidUseCase
import com.example.mobile.pruebabold.view.weather.SearchFragment
import com.example.mobile.pruebabold.view.weather.SearchViewModel
import com.example.mobile.pruebabold.view.woeid.WoeidFragment
import com.example.mobile.pruebabold.view.woeid.WoeidViewModel
import dagger.Component

@Component(modules = [
    ModuleApplication::class,
    RetrofitModule::class,
    ModuleDataSource::class,
    ModuleUseCase::class,
    ModuleRepositories::class,
    ModuleViewModels::class,
    ModuleFragment::class
])
interface ComponentApplication {

    //DataSource woeid
    fun inject(woeidRemoteDataSource: WoeidRemoteDataSource)

    //Repositories woeid
    fun inject(repoWoeid: RepoWoeid)

    //Use Case woeid
    fun inject(consulteForWoeidUseCase: ConsulteForWoeidUseCase)

    //View Models woeid
    fun inject(woeidViewModel: WoeidViewModel)

    //Frament woeid
    fun inject(woeidFragment: WoeidFragment)

    //DataSource search
    fun inject(searchRemoteDataSource: SearchRemoteDataSource)

    //Repositories search
    fun inject(repoSearch: RepoSearch)

    //Use Case search
    fun inject(consulteForSearchUseCase: ConsulteForSearchUseCase)

    //View Models search
    fun inject(searchViewModel: SearchViewModel)

    //Frament search
    fun inject(searchFragment: SearchFragment)

    //Frament search
    fun inject(mainActivity: MainActivity)

}