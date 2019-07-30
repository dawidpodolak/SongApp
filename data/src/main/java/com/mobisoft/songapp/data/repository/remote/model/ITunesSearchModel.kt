package com.mobisoft.songapp.data.repository.remote.model

import com.google.gson.annotations.SerializedName

/**
 * @author Dawid Podolak
 * Created at 2019-07-30
 */
data class ITunesSearchModel(
    @SerializedName("resultCount")
    val count: Int,
    val results: List<ITunesSearchResultItem>
) {
    data class ITunesSearchResultItem(
        @SerializedName("wrapperType")
        val wrapperType: String,
        @SerializedName("kind")
        val song: String,
        @SerializedName("artistId")
        val artistId: Int,
        @SerializedName("collectionId")
        val collectionId: Int,
        @SerializedName("trackId")
        val trackId: String,
        val artistName: String,
        val collectionName: String,
        val trackName: String,
        val collectionCensoredName: String,
        val trackCensoredName:String,
        val artistViewUrl: String,
        val collectionViewUrl: String,
        val trackViewUrl: String
    )
}