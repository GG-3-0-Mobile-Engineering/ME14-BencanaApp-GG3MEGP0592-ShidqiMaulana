package com.example.finalprojectgigih.core.domain.usecase

import com.example.finalprojectgigih.core.domain.repository.IMainRepository

class MainInteractor(private val mainRepository: IMainRepository): MainUseCase {

    override fun getReports() = mainRepository.getReports()

}