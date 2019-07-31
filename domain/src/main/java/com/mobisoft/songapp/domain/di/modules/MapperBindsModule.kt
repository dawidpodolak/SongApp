package com.mobisoft.songapp.domain.di.modules

import com.mobisoft.songapp.data.entity.SongEntity
import com.mobisoft.songapp.data.mapper.Mapper
import com.mobisoft.songapp.domain.entity.Song
import com.mobisoft.songapp.domain.mapper.SongEnitytyToSongMapper
import dagger.Binds
import dagger.Module

/**
 * @author Dawid Podolak
 * Created at 2019-07-31
 */
@Module
abstract class MapperBindsModule {

    @Binds
    abstract fun bindsSongMapper(songMapper: SongEnitytyToSongMapper): Mapper<SongEntity, Song>
}