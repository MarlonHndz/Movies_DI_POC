package com.android.marlon.dependencyinjectionpoc

import android.app.Application
import com.android.marlon.data.di.dataModule
import com.android.marlon.dependencyinjectionpoc.di.presentationModule
import com.android.marlon.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(domainModule, dataModule, presentationModule)
        }
    }
}
