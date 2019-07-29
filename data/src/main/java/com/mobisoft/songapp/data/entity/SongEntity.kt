package com.mobisoft.songapp.data.entity

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
data class SongEntity (
    val songTitle: String,
    val artistTitle: String,
    val songAndArtist: String,
    val releaseYear: Int,
    val playCount: Int,
    val first: Int,
    val year: Int,
    val fAndG: Int
    )