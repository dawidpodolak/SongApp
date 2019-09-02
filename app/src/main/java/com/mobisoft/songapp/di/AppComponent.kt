package com.mobisoft.songapp.di

import com.mobisoft.songapp.SongApp
import com.mobisoft.songapp.data.di.RepositoryComponent
import com.mobisoft.songapp.data.di.modules.RepositoryBindModule
import com.mobisoft.songapp.data.di.modules.RepositoryModule
import com.mobisoft.songapp.di.modules.ActivityModule
import com.mobisoft.songapp.di.modules.AppModule
import com.mobisoft.songapp.di.modules.ViewModelModule
import com.mobisoft.songapp.domain.di.DomainComponent
import com.mobisoft.songapp.domain.di.modules.DomainBindsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        AppModule::class],
    dependencies = [
        DomainComponent::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: SongApp): Builder

        fun appModule(appModule: AppModule): Builder

        fun domainComponent(domainComponent: DomainComponent) : Builder

        fun build(): AppComponent
    }

    fun inject(songApp: SongApp)
}