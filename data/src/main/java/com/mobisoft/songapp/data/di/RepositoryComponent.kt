package com.mobisoft.songapp.data.di

import com.mobisoft.songapp.data.di.modules.RepositoryBindModule
import com.mobisoft.songapp.data.di.qualifiers.RepoSongQualifier
import com.mobisoft.songapp.data.di.qualifiers.RepoSongQualifier.StoreType.*
import com.mobisoft.songapp.data.repository.SongRepository
import dagger.Component
import javax.inject.Singleton

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@Singleton
@Component (modules = [RepositoryBindModule::class])
interface RepositoryComponent {

    @RepoSongQualifier(Remote)
    fun remoteSongRepository(): SongRepository

    @RepoSongQualifier(Local)
    fun localSongRepository(): SongRepository

}