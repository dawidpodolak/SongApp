package com.mobisoft.songapp.data.di

import android.content.Context
import com.mobisoft.songapp.data.di.modules.RepositoryModule

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
object RepositoryComponentBuilder {

    fun build(context: Context): RepositoryComponent =
        DaggerRepositoryComponent
            .builder()
            .repositoryModule(RepositoryModule(context))
            .build()
}