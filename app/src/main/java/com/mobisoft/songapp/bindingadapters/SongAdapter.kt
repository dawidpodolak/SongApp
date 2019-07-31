@file:JvmName("SongAdapter")
package com.mobisoft.songapp.bindingadapters

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.mobisoft.songapp.R

/**
 * @author Dawid Podolak
 * Created at 2019-07-31
 */

@BindingAdapter("app:formatYear")
fun formatYear(textView: TextView, year: Int?) {
  if (year != null) {
    textView.visibility = View.VISIBLE
    textView.text = textView.context.getString(R.string.year_format, year)
  } else {
    textView.visibility = View.GONE
  }
}