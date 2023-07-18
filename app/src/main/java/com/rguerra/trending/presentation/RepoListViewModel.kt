package com.rguerra.trending.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rguerra.trending.domain.GetAndroidPublicReposCase
import com.rguerra.trending.presentation.utils.Failure
import com.rguerra.trending.presentation.utils.Resource
import com.rguerra.trending.presentation.utils.SingleLiveEvent
import com.rguerra.trending.presentation.utils.Success


class RepoListViewModel(
    private val getAndroidPublicReposCase: GetAndroidPublicReposCase
) : ViewModel() {

    private val pageFilter: Int = 1
    private val _categories: MutableLiveData<List<String>> = MutableLiveData()
    val categories: LiveData<List<String>> = _categories

    private val _result: MutableLiveData<Resource<List<Repo>>> = MutableLiveData()
    val result: MutableLiveData<Resource<List<Repo>>> = _result

    private val _filtered: MutableLiveData<Resource<List<Repo>>> = MutableLiveData()
    private val _sortedList = MutableLiveData<List<Repo>>()
    private val _loading: SingleLiveEvent<Boolean> = SingleLiveEvent()
    private val _repoMediatorList = MediatorLiveData<Resource<List<Repo>>>()

    private var page: Int = 0
    private var isLastItem = false

    val loading: LiveData<Boolean> = _loading
    val repositoriesResource: LiveData<Resource<List<Repo>>> = _repoMediatorList

    init {
        _repoMediatorList.addSource(_result) {
            _repoMediatorList.value = it
        }
        _repoMediatorList.addSource(_filtered) {
            _repoMediatorList.value = it
        }
        _repoMediatorList.addSource(_sortedList) {
            _repoMediatorList.value = Success(it)
        }
        loadInitData()
    }

    private fun loadInitData() {
        loadData(GetAndroidPublicReposCase.Param(0))
    }

    fun loadMoreData(isRefreshing: Boolean) {
        if (!isLastItem && !isRefreshing) {
            loadData(GetAndroidPublicReposCase.Param(page))
        } else {
            postHideLoading()
        }
    }

    private fun loadData(params: GetAndroidPublicReposCase.Param) {
        postShowLoading()
        getAndroidPublicReposCase.execute(
            onSuccess = ::onFetchDataSuccess,
            onError = ::onError,
            params = params
        )
    }

    private fun onError(ex: Throwable?) {
        _result.value = Failure(FailureVo.UnexpectedFailure(ex?.localizedMessage))
        postHideLoading()
    }

    private fun onFetchDataSuccess(list: List<Repo>) {
        val categories = mutableSetOf<String>()
        val repoList = mutableListOf<Repo>()

        // TODO Is this needed?
        list.forEach {
            it.technology?.let { language -> categories.add(language) }
            repoList.add(it)
        }

        _repoMediatorList.value?.fold({
            repoList.addAll(it)
        })
        _result.value = Success(repoList)
        _categories.value = categories.toList()
        page++
        isLastItem = list.isEmpty()
        postHideLoading()
    }

    fun onStop() {
        getAndroidPublicReposCase.clean()
    }

    fun onRefresh() {
        loadInitData()
    }

    fun onSearch(category: String? = null) {
        _result.value?.fold({
            _filtered.value = Success(if (category == null) {
                it
            } else {
                it.filter { repoVo ->
                    repoVo.technology == category
                }
            })
        })
    }

    fun onSortItemSelected(sortCriteriaCriteria: RepoSortCriteriaEnum) {
        _result.value?.fold(
            {
                _sortedList.value = when (sortCriteriaCriteria) {
                    RepoSortCriteriaEnum.ALPHABETIC ->
                        it.sortedBy { repoVo -> repoVo.name }
                    RepoSortCriteriaEnum.OWNER ->
                        it.sortedByDescending { repoVo -> repoVo.watchers}
                }
            }
        )
    }

    private fun postShowLoading() {
        _loading.value = true
    }

    private fun postHideLoading() {
        _loading.value = false
    }

    enum class RepoSortCriteriaEnum {
        ALPHABETIC,
        OWNER
    }
}

