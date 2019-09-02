package com.mobisoft.songapp.domain.di.qualifiers

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.*

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@Qualifier
@MustBeDocumented
@Retention(RUNTIME)
annotation class RepoSongQualifier(val store: StoreType) {

    enum class StoreType { Local, Remote }
}