package com.mobisoft.songapp.data.store

import com.mobisoft.songapp.data.entity.SongEntity
import io.reactivex.Single

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
internal interface Store {

    fun getSongs(): Single<List<SongEntity>>
}