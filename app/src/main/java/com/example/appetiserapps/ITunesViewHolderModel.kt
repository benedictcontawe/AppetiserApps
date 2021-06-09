package com.example.appetiserapps

data class ITunesViewHolderModel(
    //val id : Int,
    val name : String? = null,
    val artWork : String? = null,
    val price : String? = null,
    val genre : String? = null
) {
    constructor(musicResponseModel : MusicResponseModel) : this(musicResponseModel.name, musicResponseModel.artWork, musicResponseModel.price, musicResponseModel.genre)
}
