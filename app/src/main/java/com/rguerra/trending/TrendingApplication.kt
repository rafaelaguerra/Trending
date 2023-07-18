package com.rguerra.trending

import android.app.Application
import com.rguerra.trending.data.di.dataModule
import com.rguerra.trending.domain.di.domainModule
import com.rguerra.trending.presentation.di.presentationModule
import org.koin.core.context.startKoin

class TrendingApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin { modules(dataModule + domainModule + presentationModule) }
    }
}