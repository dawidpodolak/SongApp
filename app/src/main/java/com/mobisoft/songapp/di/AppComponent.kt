package com.mobisoft.songapp.di

import com.mobisoft.songapp.SongApp
import com.mobisoft.songapp.di.modules.ActivityModule
import com.mobisoft.songapp.di.modules.ViewModelModule
import com.mobisoft.songapp.domain.di.DomainComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityModule::class, ViewModelModule::class],dependencies = [DomainComponent::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: SongApp): Builder

        fun domainComponent(domainComponent: DomainComponent): Builder

        fun build(): AppComponent
    }

    fun inject(songApp: SongApp)
}