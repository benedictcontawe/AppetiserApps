package com.example.appetiserapps

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

public class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG : String = MainActivity::class.java.getSimpleName()

        fun newIntent(context : Context) : Intent {
            val intent : Intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            return intent
        }
    }

    private val mainViewModel : MainViewModel by viewModel<MainViewModel>()
    private val iTunesAdapter : ITunesAdapter by lazy(LazyThreadSafetyMode.NONE, initializer = { ITunesAdapter() })

    override fun onCreate(savedInstanceState : Bundle?) { Log.d(TAG,"onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView()
        if (savedInstanceState == null) { //Log.d(TAG,"getList() ${mainViewModel.checkList("start")}")
            mainViewModel.updateList("start")
        }
        observeList()
    }

    private fun setRecyclerView() { Log.d(TAG,"setRecyclerView()")
        //recycler_view.setLayoutManager(CustomLinearLayoutManager(this@MainActivity,RecyclerView.VERTICAL,false))
        recycler_view.setAdapter(iTunesAdapter)
        recycler_view.setHasFixedSize(true)
    }

    private fun observeList() { Log.d(TAG,"observeList()")
        mainViewModel.observeList().observe(this, object : Observer<List<ITunesViewHolderModel>> {
            override fun onChanged(updatedList : List<ITunesViewHolderModel>) { Log.d(TAG,"observeList() updatedList $updatedList")
                //recycler_view.invalidate()
                //recycler_view.removeAllViews()
                iTunesAdapter.setItems(updatedList)
            }
        })
    }
}