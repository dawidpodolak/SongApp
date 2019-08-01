package com.mobisoft.songapp.ui.songslist.recyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mobisoft.songapp.R
import com.mobisoft.songapp.databinding.SongItemBinding
import com.mobisoft.songapp.domain.entity.Song

/**
 * @author Dawid Podolak
 * Created at 2019-07-31
 */
class SongListAdapter(private val context: Context) : RecyclerView.Adapter<SongListAdapter.SongViewHolder>() {

  private val inflater = LayoutInflater.from(context)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder =
    DataBindingUtil.inflate<SongItemBinding>(inflater, R.layout.song_item, parent, false)
        .run { SongViewHolder(this) }

  private var songList = mutableListOf<Song>()

  override fun getItemCount(): Int = songList.size

  override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
    holder.binding.song = songList[position]
  }

  fun setSongs(songs: List<Song>) {
    songList.apply {
      clear()
      addAll(songs)
    }
    notifyDataSetChanged()
  }

  inner class SongViewHolder(val binding: SongItemBinding) : RecyclerView.ViewHolder(binding.root)
}