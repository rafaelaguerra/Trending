package com.rguerra.trending

import android.app.Application
import com.rguerra.domain.di.domainModule
import com.rguerra.presentation.di.presentationModule
import com.rguerra.data.di.dataModule
import org.koin.core.context.startKoin

class TrendingApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin { modules(dataModule + domainModule + presentationModule) }
    }
}