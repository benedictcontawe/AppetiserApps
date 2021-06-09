package com.example.appetiserapps

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppDelegate : MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@AppDelegate)
            androidFileProperties()
            koin.loadModules(
                listOf(
                    ApplicationModule.applicationModule,
                    NetworkModule.apiModule
                )
            ) // module list
        }
    }
}