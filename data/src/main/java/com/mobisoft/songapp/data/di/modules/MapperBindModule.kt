package com.mobisoft.songapp.data.di.modules

import com.mobisoft.songapp.data.entity.SongEntity
import com.mobisoft.songapp.data.mapper.LocalSongModelToEntityMapper
import com.mobisoft.songapp.data.mapper.Mapper
import com.mobisoft.songapp.data.repository.model.LocalSongModel
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
}