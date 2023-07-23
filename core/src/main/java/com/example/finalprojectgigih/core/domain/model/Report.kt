package com.example.finalprojectgigih.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Report(
    var reportId: String? = null
) : Parcelable
