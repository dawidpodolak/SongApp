package com.mobisoft.songapp.data.repository.remote

import com.mobisoft.songapp.data.di.DataScope
import com.mobisoft.songapp.domain.entity.SongEntity
import com.mobisoft.songapp.common.mapper.Mapper
import com.mobisoft.songapp.data.repository.remote.api.ItunesApi
import com.mobisoft.songapp.data.repository.remote.model.ITunesSearchModel
import com.mobisoft.songapp.data.repository.remote.model.ITunesSearchModel.*
import com.mobisoft.songapp.domain.mapper.SongEntityMapper
import com.mobisoft.songapp.domain.repository.SongRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@DataScope
internal class RemoteSongRepository @Inject constructor(
    private val api: ItunesApi,
    private val mapper: SongEntityMapper<@JvmSuppressWildcards ITunesSearchResultItem>
) : SongRepository {


    companion object {
        const val SAMPLE_ARTIST = "jack johnson" //TODO get songs functionality should be change in to search
    }

    override fun getSongs(): Single<List<SongEntity>> {
        return api.searchSongs(SAMPLE_ARTIST)
            .flatMapObservable{ Observable.fromIterable(it.results) }
            .map { mapper.map(it) }
            .toList()
    }

}