package com.mobisoft.songapp.ui.songslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mobisoft.songapp.domain.entity.Song
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
) : BaseViewModel() {

    private val songsLiveData = MutableLiveData<List<Song>>()

    private val remoteEnabled = MutableLiveData<Boolean>().apply {
        value = true
    }

    private val localEnabled = MutableLiveData<Boolean>().apply {
        value = true
    }

    var isRemote: LiveData<Boolean> = remoteEnabled

    var isLocal: LiveData<Boolean> = localEnabled

    init {
        Timber.d("init SongListViewModel")

        inflateSongs()
    }

    private fun inflateSongs() {
        val isRemoteEnabled = remoteEnabled.value == true
        val isLocalEnabled = localEnabled.value == true

        getSongs.getSongs(remote = isRemoteEnabled, local = isLocalEnabled)
            .subscribeOn(Schedulers.io())
            .subscribe({

                val stringBuilder = StringBuilder()
                it.forEach {
                    stringBuilder.append(it).append("\n")
                }
                Timber.d("Songs: \n$stringBuilder")

                songsLiveData.postValue(it)
            }, {
                Timber.e(it)
            })
            .also {
                compositeDisposable.add(it)
            }
    }

    fun getListSongs(): LiveData<List<Song>> = songsLiveData

    fun setLocal(checked: Boolean) {
        localEnabled.value = checked
        inflateSongs()
    }

    fun setRemote(checked: Boolean) {
        remoteEnabled.value = checked
        inflateSongs()
    }
}