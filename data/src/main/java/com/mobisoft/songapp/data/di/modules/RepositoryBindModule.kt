package com.mobisoft.songapp.data.di.modules

import com.mobisoft.songapp.domain.di.qualifiers.RepoSongQualifier
import com.mobisoft.songapp.domain.di.qualifiers.RepoSongQualifier.StoreType.Local
import com.mobisoft.songapp.domain.di.qualifiers.RepoSongQualifier.StoreType.Remote
import com.mobisoft.songapp.data.repository.local.LocalSongRepository
import com.mobisoft.songapp.domain.repository.SongRepository
import com.mobisoft.songapp.data.repository.local.LocalSongProvider
import com.mobisoft.songapp.data.repository.local.LocalSongProviderImpl
import com.mobisoft.songapp.data.repository.remote.RemoteSongRepository
import dagger.Binds
import dagger.Module

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@Module(includes = [RepositoryModule::class, MapperBindModule::class, ApiModule::class])
abstract class RepositoryBindModule {

    @RepoSongQualifier(Remote)
    @Binds
    internal abstract fun bindsRemoteRepository(remoteSongRepository: RemoteSongRepository): SongRepository

    @RepoSongQualifier(Local)
    @Binds
    internal abstract fun bindsLocaleRepository(localSongRepository: LocalSongRepository): SongRepository

    @Binds
    internal abstract fun bindsLocalSongProvider(localSongProviderImpl: LocalSongProviderImpl): LocalSongProvider

}
