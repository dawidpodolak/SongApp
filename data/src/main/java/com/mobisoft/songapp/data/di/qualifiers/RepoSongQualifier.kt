package com.mobisoft.songapp.data.di.qualifiers

import java.lang.annotation.Documented
import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.*

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@Qualifier
@Documented
@Retention(RUNTIME)
annotation class RepoSongQualifier(val store: StoreType) {

    enum class StoreType { Local, Remote}
}