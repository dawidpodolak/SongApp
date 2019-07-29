package com.mobisoft.songapp.data.repository

import com.mobisoft.songapp.data.di.qualifiers.StoreQualifier
import com.mobisoft.songapp.data.di.qualifiers.StoreQualifier.StoreType.Local
import com.mobisoft.songapp.data.di.qualifiers.StoreQualifier.StoreType.Remote
import com.mobisoft.songapp.data.entity.SongEntity
import com.mobisoft.songapp.data.store.Store
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@Singleton
internal class SongRepositoryImpl @Inject constructor(
    @StoreQualifier(Local) private val localStore: Store,
    @StoreQualifier(Remote) private val remoteStore: Store
): SongRepository {
    override fun getSongs(): Single<List<SongEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}