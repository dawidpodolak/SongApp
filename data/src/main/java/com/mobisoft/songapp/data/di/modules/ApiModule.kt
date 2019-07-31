package com.mobisoft.songapp.data.di.modules

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mobisoft.songapp.data.di.API_ADDRESS_QUALIFIER
import com.mobisoft.songapp.data.repository.remote.api.ItunesApi
import com.mobisoft.songapp.repository.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

/**
 * @author Dawid Podolak
 * Created at 2019-07-30
 */
@Module
class ApiModule {
    @Provides
    @Named(API_ADDRESS_QUALIFIER)
    fun providesRemoteApiAddress(): String = BuildConfig.REMOTE_API_ADDRESS

    @Provides
    fun providesRetrofit(
        @Named(API_ADDRESS_QUALIFIER) apiAddress: String
    ): Retrofit {
        val client = OkHttpClient.Builder()
            .build()

        return Retrofit.Builder()
            .baseUrl(apiAddress)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun provideITunesApi(retrofit: Retrofit): ItunesApi = retrofit.create(ItunesApi::class.java)

}