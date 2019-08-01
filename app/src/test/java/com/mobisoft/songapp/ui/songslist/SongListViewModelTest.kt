package com.mobisoft.songapp.ui.songslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mobisoft.songapp.domain.usecase.GetSongs
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times

class SongListViewModelTest {

  private val getSongs = mock(GetSongs::class.java)

  private lateinit var testTarget: SongListViewModel

  @get:Rule
  val archRule = InstantTaskExecutorRule()

  @Before
  fun setup() {
    RxJavaPlugins.setIoSchedulerHandler{ Schedulers.trampoline() }

  }

  @Test
  fun `when view model is initialized, then getSongs should be called with local and remote set on true`() {
    //when
    whenever(getSongs.getSongs(any(), any())).thenReturn(Single.fromCallable { LOCAL_SONGS })

    //then
    testTarget = SongListViewModel(getSongs)

    //verify
    val localArgumentCaptor = argumentCaptor<Boolean>()
    val remoteArgumentCaptor = argumentCaptor<Boolean>()
    verify(getSongs).getSongs(remoteArgumentCaptor.capture(), localArgumentCaptor.capture())
    assertTrue(localArgumentCaptor.firstValue)
    assertTrue(remoteArgumentCaptor.firstValue)
  }

  @Test
  fun `when local source is disabled and remote is enabled, then getSongs should be called with local=false and remote=true`() {
    //when
    whenever(getSongs.getSongs(any(), any())).thenReturn(Single.fromCallable { LOCAL_SONGS })

    //then
    testTarget = SongListViewModel(getSongs)
    testTarget.setLocal(false)

    //verify
    val localArgumentCaptor = argumentCaptor<Boolean>()
    val remoteArgumentCaptor = argumentCaptor<Boolean>()
    verify(getSongs, times(2)).getSongs(remoteArgumentCaptor.capture(), localArgumentCaptor.capture())
    assertFalse(localArgumentCaptor.secondValue)
    assertTrue(remoteArgumentCaptor.secondValue)
  }

  @Test
  fun `when local source is picked, then songs should be returned on init`() {
    //when
    whenever(getSongs.getSongs(any(), any())).thenReturn(Single.fromCallable { LOCAL_SONGS })

    //then
    testTarget = SongListViewModel(getSongs)
    val songList = testTarget.getListSongs().value

    //verify
    assertTrue(songList?.isNotEmpty() == true)
  }

}
