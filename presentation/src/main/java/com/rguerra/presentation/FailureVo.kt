package com.rguerra.presentation

sealed class FailureVo {
    data class UnexpectedFailure(val localizedMessage: String?) : FailureVo()
    abstract class FeatureFailure : FailureVo()
}
