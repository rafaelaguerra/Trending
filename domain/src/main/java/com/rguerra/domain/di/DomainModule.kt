package com.rguerra.domain.di

import com.rguerra.domain.usecase.GetAndroidPublicReposCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val SCHEDULER = "SCHEDULER"
const val MAIN_THREAD_SCHEDULER = "MAIN_THREAD_SCHEDULER"

val domainModule = module {
    single(named(SCHEDULER)) { Schedulers.newThread() }
    single(named(MAIN_THREAD_SCHEDULER)) { AndroidSchedulers.mainThread() }

    single {
        GetAndroidPublicReposCase(
            get(),
            get(named(SCHEDULER)),
            get(named(MAIN_THREAD_SCHEDULER))
        )
    }
}