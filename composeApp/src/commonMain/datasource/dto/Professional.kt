package com.nutrium.demo.datasource.dto
import kotlinx.serialization.Serializable



@Serializable
data class Professional (
    val id: Int,
    val name: String,
    val expertise: List<String>,
    val languages: List<String>,
    val profile_picture_url: String,
    val rating: Int,
    val rating_count: Int
)


@Serializable
data class ProfessionalResponse(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val professionals: List<Professional>
)

@Serializable
data class ProfessionalDetails(
    val id: Int,
    val name: String,

    @SerialName("about_me")
    val aboutMe: String,

    val expertise: List<String>,
    val languages: List<String>,

    @SerialName("profile_picture_url")
    val profilePictureUrl: String,

    val rating: Int,

    @SerialName("rating_count")
    val ratingCount: Int
)