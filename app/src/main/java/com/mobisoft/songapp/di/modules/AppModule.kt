package com.mobisoft.songapp.di.modules

import android.content.Context
import com.mobisoft.songapp.SongApp
import dagger.Module
import dagger.Provides

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@Module
class AppModule(private val songApp: SongApp) {

    @Provides
    fun providesContext(): Context = songApp.applicationContext
}