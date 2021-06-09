package com.example.appetiserapps

import android.app.Service
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Coroutines {

    private val TAG : String = Coroutines::class.java.getSimpleName()

    fun main(work : suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.Main.immediate).launch {
            work()
        }

    fun main(activity : AppCompatActivity, work : suspend (() -> Unit)) =
        activity.lifecycleScope.launch(Dispatchers.Main) { Log.d(TAG,"Dispatchers.Main Activity")
            work()
        }

    fun main(fragment : Fragment, work : suspend (() -> Unit)) =
        fragment.lifecycleScope.launch(Dispatchers.Main) { Log.d(TAG,"Dispatchers.Main Fragment")
            work()
        }

    fun main(viewModel : ViewModel, work : suspend (() -> Unit)) =
        viewModel.viewModelScope.launch(Dispatchers.Main) { Log.d(TAG,"Dispatchers.Main ViewModel")
            work()
        }

    fun mainImmediate(work : suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.Main.immediate).launch { Log.d(TAG,"Dispatchers.Main.immediate")
            work()
        }

    fun mainImmediate(fragment : Fragment, work : suspend (() -> Unit)) =
        fragment.lifecycleScope.launch(Dispatchers.Main.immediate) { Log.d(TAG,"Dispatchers.Main.immediate Fragment")
            work()
        }

    fun io(work : suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.IO).launch { Log.d(TAG,"Dispatchers.IO")
            work()
        }

    fun io(activity : AppCompatActivity, work : suspend (() -> Unit)) =
        activity.lifecycleScope.launch(Dispatchers.IO) { Log.d(TAG,"Dispatchers.IO Activity")
            work()
        }

    fun io(fragment : Fragment, work : suspend (() -> Unit)) =
        fragment.lifecycleScope.launch(Dispatchers.IO) { Log.d(TAG,"Dispatchers.IO Fragment")
            work()
        }

    fun io(viewModel : ViewModel, work : suspend (() -> Unit)) =
        viewModel.viewModelScope.launch(Dispatchers.IO) { Log.d(TAG,"Dispatchers.IO ViewModel")
            work()
        }

    fun default(work : suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.Default).launch { Log.d(TAG,"Dispatchers.Default")
            work()
        }

    fun default(activity : AppCompatActivity, work : suspend (() -> Unit)) =
        activity.lifecycleScope.launch(Dispatchers.Default) { Log.d(TAG,"Dispatchers.Default AppCompatActivity")
            work()
        }

    fun default(fragment : Fragment, work : suspend (() -> Unit)) =
        fragment.lifecycleScope.launch(Dispatchers.Default) { Log.d(TAG,"Dispatchers.Default Fragment")
            work()
        }

    fun default(viewModel : ViewModel, work : suspend (() -> Unit)) =
        viewModel.viewModelScope.launch(Dispatchers.Default) { Log.d(TAG,"Dispatchers.Default ViewModel")
            work()
        }

    fun default(service : Service, work : suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.Default).launch { Log.d(TAG,"Dispatchers.Default Service")
            work()
        }

    fun unconfined(work : suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.Unconfined).launch {
            work()
        }
}