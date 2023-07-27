package com.example.finalprojectgigih.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AreaCode(
    var code: String? = null,
    var name: String? = null
) : Parcelable
