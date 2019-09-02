package com.mobisoft.songapp.data.di.modules

import com.mobisoft.songapp.domain.entity.SongEntity
import com.mobisoft.songapp.data.mapper.ITunesModelToSongEntityMapper
import com.mobisoft.songapp.data.mapper.LocalSongModelToEntityMapper
import com.mobisoft.songapp.data.repository.local.model.LocalSongModel
import com.mobisoft.songapp.data.repository.remote.model.ITunesSearchModel
import com.mobisoft.songapp.data.repository.remote.model.ITunesSearchModel.*
import com.mobisoft.songapp.domain.mapper.SongEntityMapper
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author Dawid Podolak
 * Created at 2019-07-30
 */
@Module
abstract class MapperBindModule {

    @Binds
    internal abstract fun bindsSongMapper(localSongModelToEntityMapper: LocalSongModelToEntityMapper): SongEntityMapper<LocalSongModel>

    @Binds
    internal abstract fun bindsItunesSongMapper(itunesMapper: ITunesModelToSongEntityMapper): SongEntityMapper<ITunesSearchResultItem>
}