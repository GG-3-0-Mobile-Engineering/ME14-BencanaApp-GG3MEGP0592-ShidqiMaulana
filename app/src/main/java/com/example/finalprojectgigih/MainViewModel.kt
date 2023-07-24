package com.example.finalprojectgigih

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.finalprojectgigih.core.domain.usecase.MainUseCase

class MainViewModel(mainUseCase: MainUseCase): ViewModel() {

    val report = mainUseCase.getReports().asLiveData()

}