package com.example.appetiserapps

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository : BaseRepository {

    companion object {
        private val TAG : String = Repository::class.java.simpleName
        public val BASE_URL : String = "https://itunes.apple.com"
    }

    private val iTunesAPI : ITunesAPI//by lazy(LazyThreadSafetyMode.NONE, initializer = { NetworkClient.createService(ITunesAPI::class.java) })

    constructor(iTunesAPI : ITunesAPI) { Log.d(TAG,"constructor()")
        this.iTunesAPI = iTunesAPI
    }

    init { Log.d(TAG,"init")

    }

    override fun save(query : String) { Log.d(TAG,"save($query)")
        iTunesAPI.getMedia(query, "au", "all", 50).enqueue(object : Callback<ITunesResponseModel> {
            override fun onResponse(call : Call<ITunesResponseModel>, response : Response<ITunesResponseModel>) {
                Log.d(TAG,"isSuccessful() ${response.isSuccessful()}")
                Log.d(TAG,"errorBody() ${response.errorBody()}")
                Log.d(TAG,"body() ${response.body()}")
                Log.d(TAG,"code() ${response.code()}")
                Log.d(TAG,"headers() ${response.headers()}")
                Log.d(TAG,"message() ${response.message()}")
                Log.d(TAG,"raw() ${response.raw()}")
            }

            override fun onFailure(call : Call<ITunesResponseModel>, throwable : Throwable) {
                Log.e(TAG,"throwable ${throwable}")
            }
        })
    }

    override suspend fun search(query : String, country : String, media : String, limit : Int) : ITunesResponseModel { Log.d(TAG,"search($query)")
        val response : Response<ITunesResponseModel> = iTunesAPI.getMedia(query, country, media, limit).execute()
        Log.d(TAG,"isSuccessful() ${response.isSuccessful()}")
        Log.d(TAG,"errorBody() ${response.errorBody()}")
        Log.d(TAG,"body() ${response.body()}")
        Log.d(TAG,"code() ${response.code()}")
        Log.d(TAG,"headers() ${response.headers()}")
        Log.d(TAG,"message() ${response.message()}")
        Log.d(TAG,"raw() ${response.raw()}")
        return if (response.isSuccessful() && response.body() != null) response.body()!!
        else if (!response.isSuccessful()) ITunesResponseModel()
        else ITunesResponseModel()
    }
}