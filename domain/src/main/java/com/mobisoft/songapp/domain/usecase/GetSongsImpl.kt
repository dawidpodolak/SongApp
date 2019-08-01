package com.mobisoft.songapp.domain.usecase

import com.mobisoft.songapp.common.mapper.Mapper
import com.mobisoft.songapp.data.di.qualifiers.RepoSongQualifier
import com.mobisoft.songapp.data.di.qualifiers.RepoSongQualifier.StoreType.Local
import com.mobisoft.songapp.data.di.qualifiers.RepoSongQualifier.StoreType.Remote
import com.mobisoft.songapp.data.entity.SongEntity
import com.mobisoft.songapp.data.repository.SongRepository
import com.mobisoft.songapp.domain.di.DomainScope
import com.mobisoft.songapp.domain.entity.Song
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@DomainScope
class GetSongsImpl @Inject constructor(
    @RepoSongQualifier(Remote) private val remoteSongRepository: SongRepository,
    @RepoSongQualifier(Local) private val localSongRepository: SongRepository,
    private val mapper: Mapper<@JvmSuppressWildcards SongEntity, Song>

) : GetSongs {

    override fun getSongs(remote: Boolean, local: Boolean): Single<List<Song>> = when {
        remote && !local -> remoteSongRepository.getSongs()
        !remote && local -> localSongRepository.getSongs()
        remote && local -> {
            val remoteSongObservable = remoteSongRepository
                .getSongsAsObservable()

            val localSongObservable = localSongRepository.getSongsAsObservable()
            Observable.merge(remoteSongObservable, localSongObservable).toList()
        }
        else -> Single.just(emptyList())
    }
        .toObservable()
        .flatMap { Observable.fromIterable(it) }
        .map { mapper.map(it) }
        .toSortedList { songEntity1, songEntity2 -> songEntity1.title.compareTo(songEntity2.title) }


    private fun SongRepository.getSongsAsObservable(): Observable<SongEntity> =
        getSongs()
            .onErrorReturnItem(emptyList())
            .flatMapObservable { Observable.fromIterable(it) }

}