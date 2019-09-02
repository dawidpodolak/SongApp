package com.mobisoft.songapp.data.di

import com.mobisoft.songapp.data.di.modules.ApiModule
import com.mobisoft.songapp.data.di.modules.MapperBindModule
import com.mobisoft.songapp.data.di.modules.RepositoryBindModule
import com.mobisoft.songapp.data.di.modules.RepositoryModule
import com.mobisoft.songapp.data.repository.remote.api.ItunesApi
import com.mobisoft.songapp.domain.di.RepositoryBridgeComponent
import com.mobisoft.songapp.domain.di.qualifiers.RepoSongQualifier
import com.mobisoft.songapp.domain.di.qualifiers.RepoSongQualifier.StoreType.*
import com.mobisoft.songapp.domain.repository.SongRepository
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@DataScope
@Component (modules = [RepositoryBindModule::class, RepositoryModule::class, MapperBindModule::class, ApiModule::class])
//@Subcomponent (modules = [RepositoryModule::class, MapperBindModule::class, ApiModule::class])
interface RepositoryComponent: RepositoryBridgeComponent {

//    @RepoSongQualifier(Remote)
//    fun remoteSongRepository(): SongRepository

//    @RepoSongQualifier(Local)
//    fun localSongRepository(): SongRepository


    @Component.Builder
    interface Builder {

        fun build(): RepositoryComponent

        fun repositoryModule(repositoryModule: RepositoryModule): Builder
    }

//    fun a(): ItunesApi

//    @Subcomponent.Builder
//    interface Builder {
//
//        fun build(): RepositoryComponent
//
//        fun apiModule(apiModule: ApiModule)
//    }
}