package com.example.appetiserapps

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainViewModel : ViewModel(), KoinComponent {

    companion object {
        private val TAG : String = MainViewModel::class.java.getSimpleName()
    }

    private val baseRepository : BaseRepository by inject()
    private val liveList : MutableLiveData<List<ITunesViewHolderModel>> by lazy(LazyThreadSafetyMode.NONE, initializer = { MutableLiveData<List<ITunesViewHolderModel>>() })

    public suspend fun checkList(query : String) : String { Log.d(TAG,"checkList()")
        Log.d(TAG,"${this.baseRepository.search(query, "au", "all", 50).count} ${this.baseRepository.search(query, "au", "all", 50).results?.size}")
        this.baseRepository.search(query, "au", "all", 50).results?.map { Log.d(TAG,"$it") }
        return this.baseRepository.search(query, "au", "all", 50).count.toString()
    }

    public fun updateList(query : String) { Coroutines.io(this@MainViewModel) { Log.d(TAG,"getList()")
        val item : MutableList<ITunesViewHolderModel> = mutableListOf<ITunesViewHolderModel>()
        this.baseRepository.search(query,"au", "all", 50).results?.map {
            item.add(ITunesViewHolderModel(it))
        }
        liveList.postValue(item)
    } }

    public fun observeList() : LiveData<List<ITunesViewHolderModel>> {
        return liveList
    }
}