package com.rguerra.domain.usecase

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

sealed class BaseUseCase(
    protected val subscriberOn: Scheduler,
    protected val observerOn: Scheduler
) {
    interface Params
}

open class BaseSingleUseCase<T : Any, in P : BaseUseCase.Params>(
        subscriberOn: Scheduler,
        observerOn: Scheduler,
        private val useCase: (P) -> Single<T>
) : BaseUseCase(subscriberOn, observerOn) {

    private val subscriptions = CompositeDisposable()

    fun execute(
            onSuccess: (T) -> Unit,
            onError: (Throwable) -> Unit,
            params: P
    ) {
        subscriptions.add(useCase(params)
                .subscribeOn(subscriberOn)
                .observeOn(observerOn)
                .subscribe(onSuccess, onError))
    }

    fun subscribe(disposable: Disposable): Disposable {
        subscriptions.add(disposable)
        return disposable
    }

    fun clean() {
        subscriptions.clear()
    }
}