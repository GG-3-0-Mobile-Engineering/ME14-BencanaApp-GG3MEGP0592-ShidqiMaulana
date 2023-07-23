package com.example.finalprojectgigih.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("result")
	val result: Result? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)

data class Properties(

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("disaster_type")
	val disasterType: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("tags")
	val tags: Tags? = null,

	@field:SerializedName("partner_icon")
	val partnerIcon: Any? = null,

	@field:SerializedName("report_data")
	val reportData: Any? = null,

	@field:SerializedName("pkey")
	val pkey: String? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("partner_code")
	val partnerCode: Any? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Result(

	@field:SerializedName("features")
	val features: List<FeaturesItem?>? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class FeaturesItem(

	@field:SerializedName("geometry")
	val geometry: Geometry? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("properties")
	val properties: Properties? = null
)

data class Tags(

	@field:SerializedName("instance_region_code")
	val instanceRegionCode: String? = null,

	@field:SerializedName("district_id")
	val districtId: Any? = null,

	@field:SerializedName("local_area_id")
	val localAreaId: String? = null
)

data class Geometry(

	@field:SerializedName("coordinates")
	val coordinates: List<Any?>? = null,

	@field:SerializedName("type")
	val type: String? = null
)
