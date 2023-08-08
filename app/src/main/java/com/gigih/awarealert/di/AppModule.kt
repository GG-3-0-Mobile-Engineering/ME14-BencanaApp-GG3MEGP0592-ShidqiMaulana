package com.gigih.awarealert.di

import com.gigih.awarealert.core.domain.usecase.MainInteractor
import com.gigih.awarealert.core.domain.usecase.MainUseCase
import com.gigih.awarealert.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MainUseCase> { MainInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}