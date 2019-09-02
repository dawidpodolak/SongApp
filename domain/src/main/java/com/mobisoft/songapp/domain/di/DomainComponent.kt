package com.mobisoft.songapp.domain.di

import com.mobisoft.songapp.domain.usecase.GetSongs
import com.mobisoft.songapp.domain.di.modules.DomainBindsModule
import com.mobisoft.songapp.domain.di.modules.RepositoryBridgeModule
import dagger.Component

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@DomainScope
@Component(modules = [DomainBindsModule::class, MapperBindsModule::class, RepositoryBridgeModule::class])
interface DomainComponent {

    fun getSongs(): GetSongs

}