package com.mobisoft.songapp.domain.usecase

import com.mobisoft.songapp.domain.entity.Song
import io.reactivex.Single

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
interface GetSongs {

    fun getSongs(remote: Boolean, local: Boolean): Single<List<Song>>
}