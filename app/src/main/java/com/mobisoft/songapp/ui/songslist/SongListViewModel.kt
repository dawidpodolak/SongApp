package com.mobisoft.songapp.ui.songslist

import com.mobisoft.songapp.domain.usecase.GetSongs
import com.mobisoft.songapp.vm.BaseViewModel
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
class SongListViewModel @Inject constructor(
    private val getSongs: GetSongs
): BaseViewModel() {

    init {
        Timber.d("init SongListViewModel")

        getSongs.getSongs(true, true)
            .subscribeOn(Schedulers.io())
            .subscribe({
                Timber.d("Song: $it")
            }, {
                Timber.e(it)
            })
            .also {
                compositeDisposable.add(it)
            }
    }

}