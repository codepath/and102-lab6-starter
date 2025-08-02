package com.codepath.lab6

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class ParksResponse(
    @SerialName("data")
    val data: List<Park>?
)

@Keep
@Serializable
data class Park(
    @SerialName("fullName")
    val fullName: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("images")
    val images: List<ParkImage>?
) : java.io.Serializable {
    val imageUrl: String?
        get() = images?.firstOrNull()?.url
}

@Keep
@Serializable
data class ParkImage(
    @SerialName("url")
    val url: String?
) : java.io.Serializable
