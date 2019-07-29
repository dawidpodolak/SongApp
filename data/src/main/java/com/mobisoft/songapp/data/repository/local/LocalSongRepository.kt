package com.mobisoft.songapp.data.repository.local

import com.mobisoft.songapp.data.entity.SongEntity
import com.mobisoft.songapp.data.repository.SongRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@Singleton
internal class LocalSongRepository @Inject constructor() : SongRepository {
    override fun getSongs(): Single<List<SongEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}