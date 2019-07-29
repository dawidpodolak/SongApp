package com.mobisoft.songapp.ui.songslist

import androidx.lifecycle.ViewModel
import com.mobisoft.songapp.domain.usecase.GetSongs
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
class SongListViewModel @Inject constructor(
    private val getSongs: GetSongs
): ViewModel() {

}