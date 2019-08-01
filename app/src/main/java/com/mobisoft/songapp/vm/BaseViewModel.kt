package com.mobisoft.songapp.vm

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
open class BaseViewModel: ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.clear()
    }

    fun Disposable.collect() = compositeDisposable.add(this)
}