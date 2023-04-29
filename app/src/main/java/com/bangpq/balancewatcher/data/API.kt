package com.bangpq.googlenews.presenter.data

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface API {
    companion object {
        private const val BASE_URL = "https://api.newscatcherapi.com/v2/"
        //        private const val BASE_URL = "https://api.pexels.com/"
        private val loggingInterceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        fun getAPI(): API {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .client(
                    OkHttpClient.Builder()
                        .callTimeout(120, TimeUnit.SECONDS)
                        .connectTimeout(120, TimeUnit.SECONDS)
                        .addInterceptor(loggingInterceptor)
                        .addNetworkInterceptor(loggingInterceptor)
                        .addInterceptor(AuthenticationInterceptor())
                        .build()
                )
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(API::class.java)
        }
    }

    @GET("latest_headlines")
    @Headers("x-api-key: VpfUTQ0toCvNPP9-BUvqNFlNsQeBwmRveUppmrOuxQQ")
    //    @GET("search")
//    @Headers("Authorization: lYBtk7KSnmBxqPeE3ONiuHlWfPbsY7XHizVHUzL9YokpFr0LxNSkzwnd")
    suspend fun latest(@Query("countries") country: String): NewsDto
}

class AuthenticationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val newRequest = chain.request().newBuilder()
            // TODO: Use your API Key provided by CoinMarketCap Professional API Developer Portal.
            .addHeader("x-api-key", "VpfUTQ0toCvNPP9-BUvqNFlNsQeBwmRveUppmrOuxQQ")
            .build()

        return chain.proceed(newRequest)
    }
}
