package com.mobisoft.songapp.domain.usecase

import com.mobisoft.songapp.data.di.qualifiers.RepoSongQualifier
import com.mobisoft.songapp.data.di.qualifiers.RepoSongQualifier.StoreType.Local
import com.mobisoft.songapp.data.di.qualifiers.RepoSongQualifier.StoreType.Remote
import com.mobisoft.songapp.data.entity.SongEntity
import com.mobisoft.songapp.data.repository.SongRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
class GetSongsImpl @Inject constructor(
    @RepoSongQualifier(Remote) private val remoteSongRepository: SongRepository,
    @RepoSongQualifier(Local) private val localSongRepository: SongRepository
): GetSongs {

    override fun getSongs(remote: Boolean, local: Boolean): Single<List<SongEntity>> = localSongRepository.getSongs()

}