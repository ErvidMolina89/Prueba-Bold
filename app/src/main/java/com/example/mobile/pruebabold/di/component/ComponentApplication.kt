package com.example.mobile.pruebabold.di.component

import com.example.mobile.pruebabold.data_source.data_access.woeid.WoeidRemoteDataSource
import com.example.mobile.pruebabold.data_source.repositories.RepoWoeid
import com.example.mobile.pruebabold.di.module.*
import com.example.mobile.pruebabold.uses_case.woeid_case.ConsulteForWoeidUseCase
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

    //DataSource
    fun inject(woeidRemoteDataSource: WoeidRemoteDataSource)

    //Repositories
    fun inject(repoWoeid: RepoWoeid)

    //Use Case
    fun inject(consulteForWoeidUseCase: ConsulteForWoeidUseCase)

    //View Models
    fun inject(woeidViewModel: WoeidViewModel)

    //Frament
    fun inject(woeidFragment: WoeidFragment)

}