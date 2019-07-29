package com.mobisoft.songapp.domain.di

import com.mobisoft.songapp.data.di.RepositoryComponentBuilder

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
object DomainComponentBuilder {

    fun build(): DomainComponent =
        DaggerDomainComponent.builder()
            .repositoryComponent(RepositoryComponentBuilder.build())
            .build()

}