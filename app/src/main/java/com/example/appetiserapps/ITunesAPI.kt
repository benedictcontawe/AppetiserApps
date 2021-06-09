package com.example.appetiserapps

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesAPI {
    //https://itunes.apple.com/search?term=star&amp;country=au&amp;media=movie&amp;all
    //@GET("/search?term={query}&amp;country={country}&amp;media={media}&amp;all")
    @GET("/search")
    fun getMedia(
        @Query("term") query : String,
        @Query("country") country : String,
        @Query("media") media : String,
        @Query("limit") limit : Int
    ) : Call<ITunesResponseModel>
}