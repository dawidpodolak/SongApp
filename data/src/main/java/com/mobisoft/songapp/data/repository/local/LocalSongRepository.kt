package com.mobisoft.songapp.data.repository.local

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mobisoft.songapp.data.di.DataScope
import com.mobisoft.songapp.common.mapper.Mapper
import com.mobisoft.songapp.data.repository.local.model.LocalSongModel
import com.mobisoft.songapp.domain.entity.SongEntity
import com.mobisoft.songapp.domain.mapper.SongEntityMapper
import com.mobisoft.songapp.domain.repository.SongRepository
import io.reactivex.Single
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.Charset
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@DataScope
internal class LocalSongRepository @Inject constructor(
    private val songProvider: LocalSongProvider,
    private val songMapper: SongEntityMapper<@JvmSuppressWildcards LocalSongModel>,
    private val gson: Gson
) : SongRepository {

    override fun getSongs(): Single<List<SongEntity>> = songProvider.getSongs()
        .run {
            Single.fromCallable {
                convertInputStreamIntoSongList(this)
                    .map { songMapper.map(it) }
            }
        }


    private fun convertInputStreamIntoSongList(inputStream: InputStream): List<LocalSongModel> {
        val type = object : TypeToken<ArrayList<LocalSongModel>>() {}.type
        return gson.fromJson<ArrayList<LocalSongModel>>(
            InputStreamReader(inputStream, Charset.defaultCharset()),
            type
        )
    }

}