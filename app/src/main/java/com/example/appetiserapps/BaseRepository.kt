package com.example.appetiserapps

public interface BaseRepository {

    fun save(query : String)

    suspend fun search(query : String, country : String, media : String, limit : Int) : ITunesResponseModel
}