package com.mobisoft.songapp.data.repository.remote.api

import com.mobisoft.songapp.data.repository.remote.model.ITunesSearchModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Dawid Podolak
 * Created at 2019-07-30
 */
interface ItunesApi {

    @GET("search")
    fun searchSongs(@Query("term") query: String): Single<ITunesSearchModel>

}