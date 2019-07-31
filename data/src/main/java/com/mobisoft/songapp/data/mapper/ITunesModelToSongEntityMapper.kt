package com.mobisoft.songapp.data.mapper

import com.mobisoft.songapp.data.entity.SongEntity
import com.mobisoft.songapp.data.repository.remote.model.ITunesSearchModel
import com.mobisoft.songapp.data.utils.OpenInTest
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-31
 */
@OpenInTest
class ITunesModelToSongEntityMapper @Inject constructor() : Mapper<ITunesSearchModel.ITunesSearchResultItem, SongEntity> {
    override fun map(value: ITunesSearchModel.ITunesSearchResultItem): SongEntity = with(value) {
            SongEntity(
                title = trackName,
                artist = artistName,
                songAndArtist = createSongAndArtistCombined(value),
                releaseYear = null,
                playCount = null
            )

    }

    private fun createSongAndArtistCombined(value: ITunesSearchModel.ITunesSearchResultItem): String =
        "${value.trackName}, ${value.artistName}"
}
