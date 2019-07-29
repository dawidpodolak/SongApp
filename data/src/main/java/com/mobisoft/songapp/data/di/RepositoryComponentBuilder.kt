package com.mobisoft.songapp.data.di

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
object RepositoryComponentBuilder {

    fun build() : RepositoryComponent = DaggerRepositoryComponent.builder().build()
}