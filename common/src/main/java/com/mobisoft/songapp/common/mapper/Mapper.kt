package com.mobisoft.songapp.common.mapper

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
interface Mapper<in T, out V> {

    fun map(value: T): V
}