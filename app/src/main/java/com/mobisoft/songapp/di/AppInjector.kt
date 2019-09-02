package com.mobisoft.songapp.di

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.mobisoft.songapp.SongApp
import com.mobisoft.songapp.data.di.DaggerRepositoryComponent
import com.mobisoft.songapp.data.di.modules.RepositoryModule
import com.mobisoft.songapp.di.modules.AppModule
import com.mobisoft.songapp.domain.di.DaggerDomainComponent
import com.mobisoft.songapp.domain.di.modules.RepositoryBridgeModule
import com.mobisoft.songapp.utils.SimpleActivityLifecycleCallbacks
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
object AppInjector {

    fun init(songApp: SongApp) {

        val repositoryComponent = DaggerRepositoryComponent
            .builder()
            .repositoryModule(RepositoryModule(songApp))
            .build()

        val domainComponent = DaggerDomainComponent
            .builder()
            .repositoryBridgeModule(RepositoryBridgeModule(repositoryComponent))
            .build()

        DaggerAppComponent
            .builder()
            .application(songApp)
            .appModule(AppModule(songApp))
            .domainComponent(domainComponent)
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

        if (activity is FragmentActivity) {
            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(
                object : FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                        if (f is Injectable) {
                            AndroidSupportInjection.inject(f)
                        }
                    }
                }, true
            )
        }
    }
}