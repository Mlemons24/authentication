package com.example.authenticationapp.data.service

import com.example.authenticationapp.data.model.User
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface AuthService {

    @FormUrlEncoded
    @POST("/users/")
    suspend fun registerNewUser(
        @Field("lastName") lastName: String,
        @Field("firstName") firstName: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<User>

    @FormUrlEncoded
    @POST("/users/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<User>


    object AuthServiceCreator {

        fun newService(): AuthService {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val httpBuilder = OkHttpClient.Builder()
            httpBuilder.addInterceptor(interceptor)
            httpBuilder.addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                    val r = chain.request()
                    val builder = r.newBuilder()
                    builder.addHeader("Accept", "application/json")
                    builder.addHeader("Content-Type", "application/x-www-form-urlencoded")
                    builder.method(r.method, r.body)
                    return chain.proceed(builder.build())
                }

            })
            httpBuilder.connectTimeout(30, TimeUnit.SECONDS)
            httpBuilder.readTimeout(30, TimeUnit.SECONDS)

            val retrofit = Retrofit.Builder()
                .baseUrl("https://server-template-1.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(httpBuilder.build())
                .build()
            return retrofit.create(AuthService::class.java)
        }
    }

}