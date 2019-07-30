package com.mobisoft.songapp.data.repository.remote

import com.mobisoft.songapp.data.entity.SongEntity
import com.mobisoft.songapp.data.repository.SongRepository
import com.mobisoft.songapp.data.repository.remote.api.ItunesApi
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
//@Singleton
internal class RemoteSongRepository @Inject constructor(private val api: ItunesApi) : SongRepository {

    override fun getSongs(): Single<List<SongEntity>> {
        return api.searchSongs("jack johnson")
            .doOnSuccess { Timber.d("search result: $it") }
            .map { emptyList<SongEntity>() }
    }

}