package com.example.mobile.pruebabold.di.module

import com.example.mobile.pruebabold.di.scope.ApplicationScope
import com.example.mobile.pruebabold.uses_case.woeid_case.ConsulteForWoeidUseCase
import dagger.Module
import dagger.Provides

@Module
class ModuleUseCase {

    @ApplicationScope
    @Provides
    fun provideConsulteForWoeid() = ConsulteForWoeidUseCase()

}