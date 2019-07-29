package com.mobisoft.songapp.di

import android.app.Activity
import android.os.Bundle
import com.mobisoft.songapp.SongApp
import com.mobisoft.songapp.domain.di.DomainComponentBuilder
import com.mobisoft.songapp.utils.SimpleActivityLifecycleCallbacks
import dagger.android.AndroidInjection
import dagger.android.support.HasSupportFragmentInjector

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
object AppInjector {

    fun init(songApp: SongApp) {

        DaggerAppComponent
            .builder()
            .domainComponent(DomainComponentBuilder.build())
            .application(songApp)
            .build()
            .inject(songApp)

        songApp.registerActivityLifecycleCallbacks(object : SimpleActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, bundle: Bundle?) { handleActivity(activity) }
        })

    }

    private fun handleActivity(activity: Activity) {
        if (activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
        }
    }
}