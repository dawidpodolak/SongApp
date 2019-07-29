package com.mobisoft.songapp.di.modules

import com.mobisoft.songapp.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}