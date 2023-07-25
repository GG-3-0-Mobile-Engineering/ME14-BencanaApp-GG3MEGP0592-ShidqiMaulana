package com.example.finalprojectgigih

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.finalprojectgigih.core.domain.model.Report
import com.example.finalprojectgigih.core.domain.usecase.MainUseCase

class MainViewModel(private val mainUseCase: MainUseCase): ViewModel() {

    var reportList: MutableLiveData<List<Report>> = MutableLiveData()

    fun getReportList() = mainUseCase.getReports().asLiveData()

}