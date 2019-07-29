package com.mobisoft.songapp.domain.usecase

import com.mobisoft.songapp.data.entity.SongEntity
import io.reactivex.Single

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
interface GetSongs {

    fun getSongs(remote: Boolean, local: Boolean): Single<List<SongEntity>>
}