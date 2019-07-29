package com.mobisoft.songapp.data.di

import com.mobisoft.songapp.data.di.modules.RepositoryBindModule
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

    fun songRepository(): SongRepository
}