package com.mobisoft.songapp.data.mapper

import com.mobisoft.songapp.common.mapper.Mapper
import com.mobisoft.songapp.data.entity.SongEntity
import com.mobisoft.songapp.data.repository.model.LocalSongModel
import com.mobisoft.songapp.common.utils.OpenInTest
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@OpenInTest
internal class LocalSongModelToEntityMapper @Inject constructor():
    Mapper<LocalSongModel, SongEntity> {

    override fun map(value: LocalSongModel): SongEntity = with(value) {SongEntity(
        title = songTitle,
        artist = artist,
        playCount = playCount,
        releaseYear = parseReleaseYear(releaseYear),
        songAndArtist = tiltleAndArtistCombined
    )
}

    private fun parseReleaseYear(releaseYear: Any): Int? = when (releaseYear) {
        is Double -> releaseYear.toInt()
        is Int -> releaseYear
        is String -> releaseYear.toIntOrNull()
        else -> null
    }
}
