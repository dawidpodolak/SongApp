package com.mobisoft.songapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mobisoft.songapp.R
import com.mobisoft.songapp.ui.songslist.SongListFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {


  @Inject
  lateinit var dispatchAndroidInjector: DispatchingAndroidInjector<Fragment>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_activity)

    supportFragmentManager
      .beginTransaction()
      .add(R.id.fragment_container, SongListFragment(), SongListFragment.TAG)
      .commit()
  }

  override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchAndroidInjector
}
