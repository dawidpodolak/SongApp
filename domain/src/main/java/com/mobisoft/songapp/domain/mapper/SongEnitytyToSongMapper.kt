package com.mobisoft.songapp.domain.mapper

import com.mobisoft.songapp.data.entity.SongEntity
import com.mobisoft.songapp.data.mapper.Mapper
import com.mobisoft.songapp.data.utils.OpenInTest
import com.mobisoft.songapp.domain.entity.Song
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-31
 */
@OpenInTest
class SongEnitytyToSongMapper @Inject constructor(): Mapper<SongEntity, Song> {

    override fun map(value: SongEntity): Song = with(value) {
        Song(
            title = title,
            artist = artist,
            year = releaseYear
        )
    }
}