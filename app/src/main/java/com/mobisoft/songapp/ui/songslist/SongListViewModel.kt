package com.mobisoft.songapp.ui.songslist

import com.mobisoft.songapp.domain.usecase.GetSongs
import com.mobisoft.songapp.vm.BaseViewModel
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.lang.StringBuilder
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

        getSongs.getSongs(remote = true, local = true)
            .subscribeOn(Schedulers.io())
            .subscribe({

                val stringBuilder = StringBuilder()
                it.forEach {
                    stringBuilder.append(it).append("\n")
                }
                Timber.d("Songs: \n$stringBuilder")
            }, {
                Timber.e(it)
            })
            .also {
                compositeDisposable.add(it)
            }
    }

}