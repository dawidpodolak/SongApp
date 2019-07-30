package com.mobisoft.songapp.data.repository.local

import TEST_JSON
import com.mobisoft.songapp.data.entity.SongEntity
import com.mobisoft.songapp.data.mapper.LocalSongModelToEntityMapper
import com.mobisoft.songapp.data.mapper.Mapper
import com.mobisoft.songapp.data.repository.model.LocalSongModel
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import java.io.ByteArrayInputStream
import java.io.InputStream

/**
 * @author Dawid Podolak
 * Created at 2019-07-30
 */
class LocalSongRepositoryTest {

    private val songProvider: LocalSongProvider = mock(LocalSongProvider::class.java)
    private val mapper: Mapper<LocalSongModel, SongEntity> = LocalSongModelToEntityMapper()

    private lateinit var testTarget: LocalSongRepository

    @Before
    fun setup() {
        testTarget = LocalSongRepository(songProvider, mapper)
    }

    @Test
    fun `when getSongs is called, list of songs should be returned`() {
        //when
        whenever(songProvider.getSongs()).thenReturn(getTestJsonInputStream())

        //then
        val testObserver = testTarget.getSongs().test()
        val resultList = testObserver.values()[0]

        //verify
        assertEquals(2, resultList.size)

        assertEquals("Caught Up in You", resultList[0].title)
        assertEquals("Fantasy Girl", resultList[1].title)
    }

    private fun getTestJsonInputStream(): InputStream = ByteArrayInputStream(TEST_JSON.toByteArray())


}