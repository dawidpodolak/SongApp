package com.mobisoft.songapp.ui.songslist

import com.mobisoft.songapp.domain.entity.Song

/**
 * @author Dawid Podolak
 * Created at 2019-08-01
 */
val LOCAL_SONGS = listOf(
    Song(title = "local song 1", artist = "local artist 1", year = 2019),
    Song(title = "local song 2", artist = "local artist 2", year = 2018)
)

val REMOTE_SONGS = listOf(
    Song(title = "remote song 1", artist = "remote artist 1", year = 2019),
    Song(title = "remote song 2", artist = "remote artist 2", year = 2018)
)