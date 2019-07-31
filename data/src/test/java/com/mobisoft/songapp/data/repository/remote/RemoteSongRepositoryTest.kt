package com.mobisoft.songapp.data.repository.remote

import REMOTE_TEST_JSON
import com.google.gson.Gson
import com.mobisoft.songapp.data.entity.SongEntity
import com.mobisoft.songapp.data.mapper.ITunesModelToSongEntityMapper
import com.mobisoft.songapp.data.mapper.Mapper
import com.mobisoft.songapp.data.repository.remote.api.ItunesApi
import com.mobisoft.songapp.data.repository.remote.model.ITunesSearchModel
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.spy

class RemoteSongRepositoryTest {

    private val itunesApi: ItunesApi = mock(ItunesApi::class.java)
    private val mapper: Mapper<ITunesSearchModel.ITunesSearchResultItem, SongEntity> =
        spy(ITunesModelToSongEntityMapper())

    private lateinit var testTarget: RemoteSongRepository

    @Before
    fun setup() {
        testTarget = RemoteSongRepository(itunesApi, mapper)
    }

    @Test
    fun `when getSongs is called, then searchSongs should be used and proper data returned `() {
        //when
        whenever(itunesApi.searchSongs(any())).thenReturn(Single.fromCallable { parseRemoteTestSongs(REMOTE_TEST_JSON) })

        //then
        val result = testTarget.getSongs().test()

        //verify
        verify(itunesApi).searchSongs(any())
        val songList = result.values()[0]

        assertEquals("Better Together", songList[0].title)
        assertEquals(1, songList.size)
    }

    private fun parseRemoteTestSongs(remoteSongs: String): ITunesSearchModel {
        return Gson().fromJson(remoteSongs, ITunesSearchModel::class.java)
    }

    @Test
    fun `when when getSongs is called, map method should be used`() {
        //when
        whenever(itunesApi.searchSongs(any())).thenReturn(Single.fromCallable { parseRemoteTestSongs(REMOTE_TEST_JSON) })

        //then
        val result = testTarget.getSongs().test()

        //verify
        verify(mapper).map(any())
    }
}