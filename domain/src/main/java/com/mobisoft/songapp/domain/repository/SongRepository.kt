package com.mobisoft.songapp.domain.repository

import com.mobisoft.songapp.domain.entity.SongEntity
import io.reactivex.Single

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
interface SongRepository {

    fun getSongs(): Single<List<SongEntity>>

}