package com.example.finalprojectgigih.di

import com.example.finalprojectgigih.viewmodel.MainViewModel
import com.example.finalprojectgigih.core.domain.usecase.MainInteractor
import com.example.finalprojectgigih.core.domain.usecase.MainUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MainUseCase> { MainInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}