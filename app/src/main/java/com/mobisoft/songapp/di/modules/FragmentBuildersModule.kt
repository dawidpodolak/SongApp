package com.mobisoft.songapp.di.modules

import com.mobisoft.songapp.ui.songslist.SongListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeSongListFragment(): SongListFragment
}