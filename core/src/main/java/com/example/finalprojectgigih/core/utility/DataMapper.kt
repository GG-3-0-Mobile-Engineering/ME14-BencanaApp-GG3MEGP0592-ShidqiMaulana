package com.example.finalprojectgigih.core.utility

import com.example.finalprojectgigih.core.data.source.local.entity.AreaCodeEntity
import com.example.finalprojectgigih.core.data.source.local.entity.ReportEntity
import com.example.finalprojectgigih.core.data.source.remote.response.GeometriesItem
import com.example.finalprojectgigih.core.domain.model.AreaCode
import com.example.finalprojectgigih.core.domain.model.Report

object DataMapper {
    fun mapReportResponsesToEntities(input: List<GeometriesItem>): List<ReportEntity> {
        val reportList = ArrayList<ReportEntity>()
        input.map {
            val report = ReportEntity(
                pkey = it.properties?.pkey ?: "",
                imageUrl = it.properties?.imageUrl ?: "",
                disasterType = it.properties?.disasterType ?: "",
                title = it.properties?.title ?: "",
                description = it.properties?.text ?: "",
                status = it.properties?.status ?: "",
                createdAt = it.properties?.createdAt ?: "",
                source = it.properties?.source ?: "",
                coordinates = it.coordinates
            )
            reportList.add(report)
        }
        return reportList
    }

    fun mapReportEntitiesToDomain(input: List<ReportEntity>): List<Report> =
        input.map {
            Report(
                pkey = it.pkey,
                imageUrl = it.imageUrl,
                disasterType = it.disasterType,
                title = it.title,
                description = it.description,
                status = it.status,
                createdAt = it.createdAt,
                source = it.source,
                coordinates = it.coordinates
            )
        }

    fun mapAreaEntitiesToDomain(input: List<AreaCodeEntity>): List<AreaCode> =
        input.map {
            AreaCode(
                code = it.code,
                name = it.name,
            )
        }

    fun mapAreaDomainsToEntities(input: AreaCode): AreaCodeEntity =
        AreaCodeEntity(
            code = input.code ?: "",
            name = input.name ?: "",
        )

}