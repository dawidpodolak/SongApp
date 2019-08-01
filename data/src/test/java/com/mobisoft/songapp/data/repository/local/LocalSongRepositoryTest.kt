package com.mobisoft.songapp.data.repository.local

import LOCAL_TEST_JSON
import com.google.gson.Gson
import com.mobisoft.songapp.data.entity.SongEntity
import com.mobisoft.songapp.data.mapper.LocalSongModelToEntityMapper
import com.mobisoft.songapp.common.mapper.Mapper
import com.mobisoft.songapp.data.repository.model.LocalSongModel
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import java.io.ByteArrayInputStream
import java.io.InputStream

/**
 * @author Dawid Podolak
 * Created at 2019-07-30
 */
class LocalSongRepositoryTest {

    private val songProvider: LocalSongProvider = mock(LocalSongProvider::class.java)
    private val mapper: Mapper<LocalSongModel, SongEntity> = spy(LocalSongModelToEntityMapper())
    private val gson = Gson()

    private lateinit var testTarget: LocalSongRepository

    @Before
    fun setup() {
        testTarget = LocalSongRepository(songProvider, mapper, gson)
    }

    @Test
    fun `when getSongs is called, list of songs should be returned from LocalSongProvider`() {
        //when
        whenever(songProvider.getSongs()).thenReturn(getTestJsonInputStream())

        //then
        val testObserver = testTarget.getSongs().test()
        val resultList = testObserver.values()[0]

        //verify

        verify(songProvider).getSongs()
        assertEquals(2, resultList.size)

        assertEquals("Caught Up in You", resultList[0].title)
        assertEquals("Fantasy Girl", resultList[1].title)
    }

    private fun getTestJsonInputStream(): InputStream = ByteArrayInputStream(LOCAL_TEST_JSON.toByteArray())

    @Test
    fun `when getSongs is called, map method should be used to convert`() {
        //when
        whenever(songProvider.getSongs()).thenReturn(getTestJsonInputStream())

        //then
        testTarget.getSongs().test()

        //verify
        verify(mapper, times(2)).map(any())
    }

}