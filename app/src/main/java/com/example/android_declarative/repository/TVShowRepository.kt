package com.example.android_declarative.repository

import com.example.android_declarative.db.TVShowDao
import com.example.android_declarative.network.TVShowService
import com.example.android_imperative.model.TVShow
import javax.inject.Inject

class TVShowRepository @Inject constructor(
    private val tvShowService: TVShowService,
    private val tvShowDao: TVShowDao
) {

    suspend fun apiTVShowPopular(page: Int) = tvShowService.apiTVShowPopular(page)
    suspend fun apiTVShowDetails(q: Int) = tvShowService.apiTVShowDetails(q)

    suspend fun getTvShowsFromDB() = tvShowDao.getTVShowFromDB()
    suspend fun insertTvShowToDB(tvShow: TVShow) = tvShowDao.insertTVShowToDB(tvShow)
    suspend fun deleteTvShowsFromDB() = tvShowDao.deleteTvShowsFromDB()

}