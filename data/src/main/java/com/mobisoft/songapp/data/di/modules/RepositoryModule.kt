package com.mobisoft.songapp.data.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@Module
class RepositoryModule (private val context: Context) {

    @Provides
    fun providesContext(): Context = context
}