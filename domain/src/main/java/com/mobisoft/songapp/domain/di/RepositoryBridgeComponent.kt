package com.mobisoft.songapp.domain.di

import com.mobisoft.songapp.domain.di.qualifiers.RepoSongQualifier
import com.mobisoft.songapp.domain.repository.SongRepository

/**
 * @author Dawid Podolak
 * Created at 2019-09-02
 */
interface RepositoryBridgeComponent {


    @RepoSongQualifier(RepoSongQualifier.StoreType.Remote)
    fun remoteSongRepository(): SongRepository

    @RepoSongQualifier(RepoSongQualifier.StoreType.Local)
    fun localSongRepository(): SongRepository

}