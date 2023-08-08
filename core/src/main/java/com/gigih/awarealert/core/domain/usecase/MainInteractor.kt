package com.gigih.awarealert.core.domain.usecase

import com.gigih.awarealert.core.domain.repository.IMainRepository

class MainInteractor(private val mainRepository: IMainRepository) : MainUseCase {

    override fun getReports(areaCode: String) = mainRepository.getReports(areaCode)

    override fun getAreaNameList() = mainRepository.getAreaNameList()

    override fun getAreaCodeList() = mainRepository.getAreaCodeList()

}