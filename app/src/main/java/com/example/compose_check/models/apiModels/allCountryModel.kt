package com.example.compose_check.models.apiModels

import kotlinx.serialization.Serializable

@Serializable
data class AllCountryDataModel(
    val code: Int?,
    val `data`: List<Data>?
) : java.io.Serializable

@Serializable
data class Data(
    val confirmed: Int?,
    val country_code: String?,
    val dead: Int?,
    val latitude: Double?,
    val location: String?,
    val longitude: Double?,
    val recovered: Int?,
    val updated: String?
) : java.io.Serializable