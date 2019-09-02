package com.mobisoft.songapp.data.mapper

import com.mobisoft.songapp.domain.entity.SongEntity
import com.mobisoft.songapp.data.repository.remote.model.ITunesSearchModel.*
import com.mobisoft.songapp.domain.mapper.SongEntityMapper
import com.mobisoft.songapp.domain.utils.OpenInTest
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-31
 */
@OpenInTest
internal class ITunesModelToSongEntityMapper @Inject constructor() :
    SongEntityMapper<ITunesSearchResultItem> {

    override fun map(value: ITunesSearchResultItem): SongEntity = with(value) {
        SongEntity(
            title = trackName,
            artist = artistName,
            songAndArtist = createSongAndArtistCombined(value),
            releaseYear = null,
            playCount = null
        )

    }

    private fun createSongAndArtistCombined(value: ITunesSearchResultItem): String =
        "${value.trackName}, ${value.artistName}"
}
