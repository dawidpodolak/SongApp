package com.mobisoft.songapp.data.repository.local

import android.content.Context
import com.mobisoft.songapp.repository.R
import java.io.InputStream
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-30
 */
internal interface LocalSongProvider {

    fun getSongs(): InputStream
}

internal class LocalSongProviderImpl @Inject constructor(private val context: Context) : LocalSongProvider {

    override fun getSongs(): InputStream = context.resources.openRawResource(R.raw.songs_list)

}