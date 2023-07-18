package com.rguerra.trending.presentation.utils

import com.rguerra.trending.presentation.FailureVo


sealed class Resource<T> {
    inline fun fold(
        onData: (T) -> Unit,
        onFailure: (FailureVo?) -> Unit = {}
    ) {
        when (this) {
            is Success -> onData(data)
            is Failure -> onFailure(failureBo)
        }
    }
}

class Success<T>(val data: T) : Resource<T>()
class Failure<T>(val failureBo: FailureVo? = null) : Resource<T>()