package com.mobisoft.songapp.data.repository

import com.mobisoft.songapp.data.entity.SongEntity
import io.reactivex.Single

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
interface SongRepository {

    fun getSongs(): Single<List<SongEntity>>

}