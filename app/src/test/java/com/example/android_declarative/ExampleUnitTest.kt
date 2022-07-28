package com.example.android_declarative

import com.example.android_declarative.di.AppModule
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun checkStatusCode() = runTest {
        val response = AppModule().tvShowService().apiTVShowPopular(1)
        assertEquals(response.code(), 200)
    }

    @Test
    fun responseIsSuccessful() = runTest {
        val response = AppModule().tvShowService().apiTVShowPopular(1)
        assertTrue(response.isSuccessful)
    }

    @Test
    fun checkTVShowListNotNull() = runTest {
        val response = AppModule().tvShowService().apiTVShowPopular(1)
        assertNotNull(response.body())
        assertNotNull(response.body()!!.tv_shows)
    }

    @Test
    fun checkTVShowListSize() = runTest {
        val response = AppModule().tvShowService().apiTVShowPopular(1)
        val tvShowPopular = response.body()
        assertEquals(tvShowPopular!!.tv_shows.size, 20)
    }

    @Test
    fun checkTVShowStatus() = runTest {
        val response = AppModule().tvShowService().apiTVShowPopular(1)
        val tvShowPopular = response.body()
        val tvShows = tvShowPopular!!.tv_shows
        val tvShow = tvShows[0]
        assertEquals(tvShow.status, "Running")
    }

    @Test
    fun checkTVShowDetailsStatus() = runTest {
        val response = AppModule().tvShowService().apiTVShowDetails(35624)
        assertEquals(response.code(), 200)
    }

    @Test
    fun checkTVShowDetailsListSize() = runTest {
        val response = AppModule().tvShowService().apiTVShowDetails(35624)
        assertTrue(response.isSuccessful)
    }

    @Test
    fun checkTVShowDetailsName() = runTest {
        val response = AppModule().tvShowService().apiTVShowDetails(35624)
        val tvShow = response.body()
        assertNotNull(tvShow)
        assertEquals(tvShow!!.tvShow.name, "The Flash")
    }

}