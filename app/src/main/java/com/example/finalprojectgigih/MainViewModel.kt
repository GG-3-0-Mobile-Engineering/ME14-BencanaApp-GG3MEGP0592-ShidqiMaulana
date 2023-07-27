package com.example.finalprojectgigih

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.finalprojectgigih.core.domain.model.AreaCode
import com.example.finalprojectgigih.core.domain.model.Report
import com.example.finalprojectgigih.core.domain.usecase.MainUseCase

class MainViewModel(private val mainUseCase: MainUseCase) : ViewModel() {

    var reportList: MutableLiveData<List<Report>> = MutableLiveData()

    fun getReportList(areaCode: String) = mainUseCase.getReports(areaCode).asLiveData()

    var areaNameList: List<String> = mainUseCase.getAreaNameList()

    var areaCodeList: List<AreaCode> = mainUseCase.getAreaCodeList()

    fun searchAreaCode(areaName: String): String {
        var areaCode = ""
        for (area in areaCodeList) {
            if (area.name == areaName) {
                areaCode = area.code!!
            }
        }
        return areaCode
    }

}