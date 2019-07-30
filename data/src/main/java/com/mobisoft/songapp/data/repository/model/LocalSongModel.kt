package com.mobisoft.songapp.data.repository.model

import com.google.gson.annotations.SerializedName

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
data class LocalSongModel(
    @SerializedName("Song Clean")
    val songTitle: String,
    @SerializedName("ARTIST CLEAN")
    val artist: String,
    @SerializedName("Release Year")
    val releaseYear: Any,
    @SerializedName("COMBINED")
    val tiltleAndArtistCombined: String,
    @SerializedName("PlayCount")
    val playCount: Int
)