package com.example.appetiserapps

data class ITunesRequestModel (
    var query : String? = null,
    var country : String? = null,
    var media : String? = null
) {
    override fun toString() : String {
        return "query $query country $country media $media" ?: super.toString()
    }
}