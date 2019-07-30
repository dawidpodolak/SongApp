package com.mobisoft.songapp.data.repository.local

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mobisoft.songapp.data.entity.SongEntity
import com.mobisoft.songapp.data.mapper.Mapper
import com.mobisoft.songapp.data.repository.SongRepository
import com.mobisoft.songapp.data.repository.model.LocalSongModel
import io.reactivex.Single
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.Charset
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
//@Singleton
internal class LocalSongRepository @Inject constructor(
    private val songProvider: LocalSongProvider,
    private val songMapper: Mapper<@JvmSuppressWildcards LocalSongModel, SongEntity>
) : SongRepository {

    override fun getSongs(): Single<List<SongEntity>> = songProvider.getSongs()
        .run {
            Single.fromCallable<List<SongEntity>> {
                convertInputStreamIntoSongList(this)
                    .map { songMapper.map(it) }
            }
        }


    private fun convertInputStreamIntoSongList(inputStream: InputStream): List<LocalSongModel> {
        val type = object : TypeToken<ArrayList<LocalSongModel>>() {}.type
        return Gson().fromJson<ArrayList<LocalSongModel>>(
            InputStreamReader(inputStream, Charset.defaultCharset()),
            type
        )
    }

}