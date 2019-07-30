package com.mobisoft.songapp.ui.songslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mobisoft.songapp.R
import com.mobisoft.songapp.di.Injectable
import com.mobisoft.songapp.vm.ViewModelFactory
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
class SongListFragment : Fragment(), Injectable {

    companion object {
        const val TAG = "SongListFragment"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var songListViewModel: SongListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.song_list_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        songListViewModel = ViewModelProviders.of(this, viewModelFactory).get(SongListViewModel::class.java)
    }
}