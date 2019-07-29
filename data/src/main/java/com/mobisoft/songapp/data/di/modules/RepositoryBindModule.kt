package com.mobisoft.songapp.data.di.modules

import com.mobisoft.songapp.data.di.qualifiers.StoreQualifier
import com.mobisoft.songapp.data.di.qualifiers.StoreQualifier.StoreType.Local
import com.mobisoft.songapp.data.di.qualifiers.StoreQualifier.StoreType.Remote
import com.mobisoft.songapp.data.repository.SongRepository
import com.mobisoft.songapp.data.repository.SongRepositoryImpl
import com.mobisoft.songapp.data.store.LocalStore
import com.mobisoft.songapp.data.store.RemoteStore
import com.mobisoft.songapp.data.store.Store
import dagger.Binds
import dagger.Module

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@Module
abstract class RepositoryBindModule {

    @StoreQualifier(Local)
    @Binds
    internal abstract fun bindsLocalStore(localStore: LocalStore): Store

    @StoreQualifier(Remote)
    @Binds
    internal abstract fun bindsRemoteStore(localStore: RemoteStore): Store

    @Binds
    internal abstract fun bindsRepository(songRepositoryImpl: SongRepositoryImpl): SongRepository

}