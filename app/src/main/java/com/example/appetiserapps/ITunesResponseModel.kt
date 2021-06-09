package com.example.appetiserapps

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ITunesResponseModel (

    @SerializedName("resultCount")
    @Expose
    var count : Int? = null,

    @SerializedName("results")
    @Expose
    var results : List<MusicResponseModel>? = null
) {
    override fun toString() : String {
        return "count $count ${results?.map { it }}" ?: super.toString()
    }
}