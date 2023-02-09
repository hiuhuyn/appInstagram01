package com.example.instagram01.Fragments.search

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {
    private val mutableSelectedItem = MutableLiveData<ClipData.Item>()
    val selectedItem: LiveData<ClipData.Item> get() = mutableSelectedItem

    fun selectItem(item: ClipData.Item) {
        mutableSelectedItem.value = item
    }
}