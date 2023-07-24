package com.example.finalprojectgigih.core.utility

import com.example.finalprojectgigih.core.data.source.local.entity.ReportEntity
import com.example.finalprojectgigih.core.data.source.remote.response.GeometriesItem
import com.example.finalprojectgigih.core.domain.model.Report

object DataMapper {
    fun mapResponsesToEntities(input: List<GeometriesItem>): List<ReportEntity> {
        val reportList = ArrayList<ReportEntity>()
        input.map {
            val report = ReportEntity(
                id = it.properties?.pkey ?: "",
            )
            reportList.add(report)
        }
        return reportList
    }

    fun mapEntitiesToDomain(input: List<ReportEntity>): List<Report> =
        input.map {
            Report(
                reportId = it.id,
            )
        }
}