package com.gigih.awarealert.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Report(
    var pkey: String? = null,
    var imageUrl: String? = null,
    var disasterType: String? = null,
    var title: String? = null,
    var description: String? = null,
    var status: String? = null,
    var createdAt: String? = null,
    var source: String? = null,
    var coordinates: List<Double?>? = ArrayList(),
) : Parcelable
