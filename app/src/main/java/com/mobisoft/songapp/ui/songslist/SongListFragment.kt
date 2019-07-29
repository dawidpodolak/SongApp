package com.mobisoft.songapp.ui.songslist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mobisoft.songapp.vm.ViewModelFactory
import javax.inject.Inject

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
class SongListFragment : Fragment() {

    companion object {
        const val TAG = "SongListFragment"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var songListViewModel: SongListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        songListViewModel = ViewModelProviders.of(this, viewModelFactory).get(SongListViewModel::class.java)
    }
}