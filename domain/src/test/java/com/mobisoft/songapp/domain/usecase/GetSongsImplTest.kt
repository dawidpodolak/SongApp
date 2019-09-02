package com.mobisoft.songapp.domain.usecase

import com.mobisoft.songapp.domain.repository.SongRepository
import com.mobisoft.songapp.data.mapper.mapper.SongEnitytyToSongMapper
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.spy
import java.net.UnknownHostException

class GetSongsImplTest {

    private val localRepository: SongRepository = mock(SongRepository::class.java)
    private val remoteRepository: SongRepository = mock(SongRepository::class.java)

    private val mapper = spy(com.mobisoft.songapp.data.mapper.mapper.SongEnitytyToSongMapper())

    private lateinit var testTarget: GetSongsImpl

    @Before
    fun setupe() {
        testTarget = GetSongsImpl(remoteRepository, localRepository, mapper)
    }

    @Test
    fun `when local songs are required, getSongs should use only localRepository`() {
        //when
        whenever(localRepository.getSongs()).thenReturn(Single.fromCallable { LOCAL_SONGS })

        //then
        testTarget.getSongs(remote = false, local = true).test()

        //verify
        verify(localRepository).getSongs()
        verify(remoteRepository, times(0)).getSongs()

    }

    @Test
    fun `when remote songs are required, getSongs should use only remoteRepository`() {
        //when
        whenever(remoteRepository.getSongs()).thenReturn(Single.fromCallable { REMOTE_SONGS })

        //then
        testTarget.getSongs(remote = true, local = false).test()

        //verify
        verify(remoteRepository).getSongs()
        verify(localRepository, times(0)).getSongs()

    }

    @Test
    fun `when remote and local songs are required, getSongs should use both repositories`() {
        //when
        whenever(localRepository.getSongs()).thenReturn(Single.fromCallable { LOCAL_SONGS })
        whenever(remoteRepository.getSongs()).thenReturn(Single.fromCallable { REMOTE_SONGS })

        //then
        testTarget.getSongs(remote = true, local = true).test()

        //verify
        verify(remoteRepository).getSongs()
        verify(localRepository).getSongs()

    }

    @Test
    fun `in case of both repositories, remote fails, local songs should be returned` () {
        //when
        whenever(localRepository.getSongs()).thenReturn(Single.fromCallable { LOCAL_SONGS })
        whenever(remoteRepository.getSongs()).thenReturn(Single.error(UnknownHostException("Remote server is unreachable")))

        //then
        val result = testTarget.getSongs(remote = true, local = true).test()

        //verify
        result.assertValueAt(0) {songs ->
            val firstLocalSongsFound = LOCAL_SONGS.find { it.title == songs[0].title } != null
            val secondLocalSongsFound = LOCAL_SONGS.find { it.title == songs[1].title } != null
            firstLocalSongsFound && secondLocalSongsFound
        }
    }

    @Test
    fun `test of async`() {
        //when
        whenever(localRepository.getSongs()).thenReturn(Single.fromCallable { LOCAL_SONGS })
        whenever(remoteRepository.getSongs()).thenReturn(Single.fromCallable { REMOTE_SONGS })

        //then
        testTarget.getSongs1(remote = true, local = true).test().awaitTerminalEvent()


    }
}