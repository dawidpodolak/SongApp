package com.mobisoft.songapp.domain.usecase

import com.mobisoft.songapp.domain.repository.SongRepository
import com.mobisoft.songapp.domain.di.DomainScope
import com.mobisoft.songapp.domain.di.qualifiers.RepoSongQualifier
import com.mobisoft.songapp.domain.di.qualifiers.RepoSongQualifier.StoreType.*
import com.mobisoft.songapp.domain.entity.SongEntity
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
@DomainScope
class GetSongsImpl @Inject constructor(
    @RepoSongQualifier(Remote) private val remoteSongRepository: SongRepository,
    @RepoSongQualifier(Local) private val localSongRepository: SongRepository
    ) : GetSongs {

    data class DataClass(val war1: Boolean, val war2: Boolean, val war3: Boolean)


    val map = mapOf (
        DataClass(true, false, true) to "Spotify"
    )

    override fun getSongs(remote: Boolean, local: Boolean): Single<List<SongEntity>> = when {
        remote && !local -> remoteSongRepository.getSongs()
        !remote && local -> localSongRepository.getSongs()
        remote && local -> {
            val remoteSongObservable = remoteSongRepository
                .getSongsAsObservable()

            val localSongObservable = localSongRepository.getSongsAsObservable()
            Observable.merge(
                remoteSongObservable.subscribeOn(Schedulers.io()),
                localSongObservable.subscribeOn(Schedulers.io()))
                .toList()
        }
        else -> Single.just(emptyList())
    }
        .toObservable()
        .flatMap { Observable.fromIterable(it) }
        .toSortedList { songEntity1, songEntity2 -> songEntity1.title.compareTo(songEntity2.title) }


    fun getSongs1(remote: Boolean, local: Boolean): Single<List<SongEntity>> = when {
        remote && !local -> remoteSongRepository.getSongs()
        !remote && local -> localSongRepository.getSongs()
        remote && local -> {
            val remoteSongObservable = remoteSongRepository
                .getSongsAsObservable()

            val localSongObservable = localSongRepository.getSongsAsObservable()
            Observable.merge(
                remoteSongObservable
                .subscribeOn(Schedulers.io())
                .doOnNext { println("Song remote: thread: ${Thread.currentThread()}")} ,

                localSongObservable)
                .subscribeOn(Schedulers.io())
                .doOnNext { println("Song local: thread: ${Thread.currentThread()}")}.toList()
        }
        else -> Single.just(emptyList())
    }
        .toObservable()
        .flatMap { Observable.fromIterable(it) }
        .toSortedList { songEntity1, songEntity2 -> songEntity1.title.compareTo(songEntity2.title) }

    private fun SongRepository.getSongsAsObservable(): Observable<SongEntity> =
        getSongs()
            .onErrorReturnItem(emptyList())
            .flatMapObservable { Observable.fromIterable(it) }

}