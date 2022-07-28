package com.example.android_imperative.model

data class TvShowDetails(
    val tvShow: Details
)

data class Details(
    val id: Long,
    val name: String,
    val permalink: String,
    val url: String,
    val description: String,
    val descriptionSource:String,
    val startDate: String,
    val endDate: String,
    val country: String,
    val status: String,
    val runtime: Long,
    val network: String,
    val youtubeLink: Any? = null,
    val image_path: String,
    val image_thumbnail_path: String,
    val rating: String,
    val ratingCount: String,
    val countDown: Any? = null,
    val genres: List<String>,
    val pictures: List<String>,
    val episodes: List<Episode>
)

data class Episode(
    val season: Long,
    val episode: Long,
    val name: String,
    val air_date: String
)

