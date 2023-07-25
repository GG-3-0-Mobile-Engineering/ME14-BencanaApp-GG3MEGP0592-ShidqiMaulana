package com.example.finalprojectgigih.core.utility

import com.example.finalprojectgigih.core.data.source.local.entity.ReportEntity
import com.example.finalprojectgigih.core.data.source.remote.response.GeometriesItem
import com.example.finalprojectgigih.core.domain.model.Report

object DataMapper {
    fun mapResponsesToEntities(input: List<GeometriesItem>): List<ReportEntity> {
        val reportList = ArrayList<ReportEntity>()
        input.map {
            val report = ReportEntity(
                pkey = it.properties?.pkey ?: "",
                imageUrl = it.properties?.imageUrl ?: "",
                disasterType = it.properties?.disasterType ?: "",
                title = it.properties?.title ?: "",
                description = it.properties?.text ?: "",
                coordinates = it.coordinates
            )
            reportList.add(report)
        }
        return reportList
    }

    fun mapEntitiesToDomain(input: List<ReportEntity>): List<Report> =
        input.map {
            Report(
                pkey = it.pkey,
                imageUrl = it.imageUrl,
                disasterType = it.disasterType,
                title = it.title,
                description = it.description,
                coordinates = it.coordinates
            )
        }
}