package com.mobisoft.songapp.data.store

import com.mobisoft.songapp.data.entity.SongEntity
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
internal class RemoteStore @Inject constructor(): Store {

    override fun getSongs(): Single<List<SongEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}