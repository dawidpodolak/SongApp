package com.mobisoft.songapp.domain.di

import com.mobisoft.songapp.domain.usecase.GetSongs
import com.mobisoft.songapp.data.di.RepositoryComponent
import com.mobisoft.songapp.domain.di.modules.DomainBindsModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@DomainScope
@Component(modules = [DomainBindsModule::class], dependencies = [RepositoryComponent::class])
interface DomainComponent {

    fun getSongs(): GetSongs

}