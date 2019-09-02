package com.mobisoft.songapp.domain.di.modules

import com.mobisoft.songapp.domain.di.RepositoryBridgeComponent
import com.mobisoft.songapp.domain.di.qualifiers.RepoSongQualifier
import com.mobisoft.songapp.domain.repository.SongRepository
import dagger.Module
import dagger.Provides

/**
 * @author Dawid Podolak
 * Created at 2019-09-02
 */
@Module
class RepositoryBridgeModule(private val repositoryBridgeComponent: RepositoryBridgeComponent) {


    @Provides
    @RepoSongQualifier(RepoSongQualifier.StoreType.Local)
    fun providesLocalRepo(): SongRepository = repositoryBridgeComponent.localSongRepository()

    @Provides
    @RepoSongQualifier(RepoSongQualifier.StoreType.Remote)
    fun providesRemoteRepo(): SongRepository = repositoryBridgeComponent.remoteSongRepository()

}