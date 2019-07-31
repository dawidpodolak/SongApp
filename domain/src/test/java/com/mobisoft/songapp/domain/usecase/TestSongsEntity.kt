package com.mobisoft.songapp.domain.usecase

import com.mobisoft.songapp.data.entity.SongEntity

/**
 * @author Dawid Podolak
 * Created at 2019-07-31
 */

val LOCAL_SONGS = listOf(
    SongEntity(title = "local song 1", artist = "local artist 1", releaseYear = 2019, songAndArtist = "local song 1, local artist 1", playCount = 2),
    SongEntity(title = "local song 2", artist = "local artist 2", releaseYear = 2018, songAndArtist = "local song 2, local artist 2", playCount = 3)
)

val REMOTE_SONGS = listOf(
    SongEntity(title = "remote song 1", artist = "remote artist 1", releaseYear = 2019, songAndArtist = "remote song 1, remote artist 1", playCount = 2),
    SongEntity(title = "remote song 2", artist = "remote artist 2", releaseYear = 2018, songAndArtist = "remote song 2, remote artist 2", playCount = 3)
)