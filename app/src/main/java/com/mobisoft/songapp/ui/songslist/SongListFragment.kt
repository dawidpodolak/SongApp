package com.mobisoft.songapp.ui.songslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobisoft.songapp.R
import com.mobisoft.songapp.databinding.SongListFragmentBinding
import com.mobisoft.songapp.di.Injectable
import com.mobisoft.songapp.domain.entity.Song
import com.mobisoft.songapp.ui.songslist.recyclerView.SongListAdapter
import com.mobisoft.songapp.vm.ViewModelFactory
import timber.log.Timber
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

  private lateinit var binding: SongListFragmentBinding

  private lateinit var songRecyclerView: RecyclerView
  private lateinit var songsPlaceholder: TextView

  private lateinit var songListAdapter: SongListAdapter

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.song_list_fragment, container, false)
    songRecyclerView = binding.songsRecyclerView
    songsPlaceholder = binding.emptySongsPlaceHolder

    binding.lifecycleOwner = this


    songListAdapter = SongListAdapter(requireContext())
    songRecyclerView.adapter = songListAdapter

    songRecyclerView.layoutManager = LinearLayoutManager(requireContext())

    setupToolbar()

    return binding.root
  }

  private fun setupToolbar() {
    if (activity is AppCompatActivity) {
      with(activity as AppCompatActivity) {
        setSupportActionBar(binding.toolbar)
        setHasOptionsMenu(true)
      }
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
    inflater?.inflate(R.menu.toolbar_menu, menu)
    menu?.findItem(R.id.menu_remote_songs)?.isChecked = songListViewModel.isRemote.value == true
    menu?.findItem(R.id.menu_local_songs)?.isChecked = songListViewModel.isLocal.value == true
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    when (item?.itemId) {
      R.id.menu_local_songs -> {
        item.isChecked = !item.isChecked
        songListViewModel.setLocal(item.isChecked)
        Timber.d("local song clicked")
      }
      R.id.menu_remote_songs -> {
        item.isChecked = !item.isChecked
        songListViewModel.setRemote(item.isChecked)
        Timber.d("remote song clicked")
      }
    }
    return true
  }

  private fun setMenuCheckBoxState(item: MenuItem?) {
    with(item?.actionView as CheckBox) {
      isChecked = !isChecked
    }
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    songListViewModel = ViewModelProviders.of(this, viewModelFactory)
        .get(SongListViewModel::class.java)
    binding.viewModel = songListViewModel

    subscribeToViewModel()
  }

  private fun subscribeToViewModel() {
    songListViewModel.getListSongs()
        .observe(this,
            Observer<List<Song>> {
              songsPlaceholder.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
              songListAdapter.setSongs(it)
            })
  }
}