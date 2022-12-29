package com.sijanneupane.mvvmnews.api

import com.sijanneupane.mvvmnews.models.NewsResponse
import com.sijanneupane.mvvmnews.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    /* menggunakan antarmuka Api untuk mengakses api untuk permintaan  */

    @GET("v2/top-headlines")

    //function
    //async
    //coroutine
    suspend fun getBreakingNews(
        //meminta parameter untuk berfungsi
    @Query("country")
    countryCode: String = "us",

    @Query("page")  //untuk paginasi permintaan
    pageNumber: Int= 1,

    @Query("apiKey")
    apiKey: String= API_KEY

    ):Response<NewsResponse> //respon balik


    @GET("v2/everything")

    suspend fun searchForNews(
        //meminta parameter untuk berfungsi
        @Query("q")
        searchQuery: String,
        @Query("page")  //untuk paginasi permintaan
        pageNumber: Int= 1,
        @Query("apiKey")
        apiKey: String= API_KEY
    ):Response<NewsResponse> //respon balik
}