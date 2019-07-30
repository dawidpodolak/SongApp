package com.mobisoft.songapp.data.repository.local

import java.io.InputStream

/**
 * @author Dawid Podolak
 * Created at 2019-07-30
 */
internal interface LocalSongProvider {

    fun getSongs(): InputStream
}