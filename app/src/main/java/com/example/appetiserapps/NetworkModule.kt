package com.example.appetiserapps

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    val apiModule = module {

        single {
            provideRetrofit(get<Gson>())
        }

        factory {
            provideGsonBuilder()
        }

        factory<ITunesAPI> {
            provideITunesAPI(get<Retrofit>())
        }

    }

    private fun provideGsonBuilder() : Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    private fun provideRetrofit(gson : Gson) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Repository.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    private fun <S> createService(retrofit : Retrofit, serviceClass: Class<S>?) : S {
        return retrofit.create(serviceClass)
    }

    private fun provideITunesAPI(retrofit : Retrofit) : ITunesAPI {
        return createService(retrofit, ITunesAPI::class.java)
    }
}