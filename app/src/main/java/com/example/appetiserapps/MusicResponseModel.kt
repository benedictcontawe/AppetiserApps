package com.example.appetiserapps

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MusicResponseModel (
    @SerializedName("trackName")
    @Expose
    var name : String? = null,

    @SerializedName("artworkUrl100")
    @Expose
    var artWork : String? = null,

    @SerializedName("trackPrice")
    @Expose
    var price : String? = null,

    @SerializedName("primaryGenreName")
    @Expose
    var genre : String? = null
) {
    override fun toString() : String {
        return "name $name, artWork $artWork, price $price, genre $genre" ?: super.toString()
    }
}