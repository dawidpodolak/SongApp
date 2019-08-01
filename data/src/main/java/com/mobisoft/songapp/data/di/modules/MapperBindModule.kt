package com.mobisoft.songapp.data.di.modules

import com.mobisoft.songapp.common.mapper.Mapper
import com.mobisoft.songapp.data.entity.SongEntity
import com.mobisoft.songapp.data.mapper.ITunesModelToSongEntityMapper
import com.mobisoft.songapp.data.mapper.LocalSongModelToEntityMapper
import com.mobisoft.songapp.data.repository.model.LocalSongModel
import com.mobisoft.songapp.data.repository.remote.model.ITunesSearchModel
import dagger.Binds
import dagger.Module

/**
 * @author Dawid Podolak
 * Created at 2019-07-30
 */
@Module
abstract class MapperBindModule {

    @Binds
    internal abstract fun bindsSongMapper(localSongModelToEntityMapper: LocalSongModelToEntityMapper): Mapper<LocalSongModel, SongEntity>

    @Binds
    internal abstract fun bindsItunesSongMapper(itunesMapper: ITunesModelToSongEntityMapper): Mapper<ITunesSearchModel.ITunesSearchResultItem, SongEntity>
}