package com.mobisoft.songapp.domain.di.modules

import com.mobisoft.songapp.domain.usecase.GetSongs
import com.mobisoft.songapp.domain.usecase.GetSongsImpl
import dagger.Binds
import dagger.Module

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@Module
abstract class DomainBindsModule {

    @Binds
    internal abstract fun bingGetSongs(getSongsImpl: GetSongsImpl): GetSongs
}