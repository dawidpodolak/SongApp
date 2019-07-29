package com.mobisoft.songapp

import android.app.Activity
import android.app.Application
import com.mobisoft.songapp.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
class SongApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        AppInjector.init(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchActivityInjector
}
