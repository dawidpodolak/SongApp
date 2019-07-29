package com.mobisoft.songapp.di.modules

import androidx.lifecycle.ViewModel
import com.mobisoft.songapp.ui.songslist.SongListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SongListViewModel::class)
    abstract fun bindSongListViewModel(slViewModel: SongListViewModel): ViewModel
}