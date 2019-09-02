package com.mobisoft.songapp.domain.entity

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
data class SongEntity (
    val title: String,
    val artist: String,
    val songAndArtist: String,
    val releaseYear: Int?,
    val playCount: Int?)