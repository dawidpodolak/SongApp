package com.mobisoft.songapp.data.mapper

import com.mobisoft.songapp.domain.entity.SongEntity
import com.mobisoft.songapp.data.repository.local.model.LocalSongModel
import com.mobisoft.songapp.domain.mapper.SongEntityMapper
import com.mobisoft.songapp.domain.utils.OpenInTest
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@OpenInTest
internal class LocalSongModelToEntityMapper @Inject constructor() :
    SongEntityMapper<LocalSongModel> {

    override fun map(value: LocalSongModel): SongEntity = with(value) {
        SongEntity(
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
