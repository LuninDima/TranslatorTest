package com.example.translatortest.view.main

import androidx.lifecycle.LiveData
import com.example.translatortest.model.data.AppState
import com.example.translatortest.model.datasource.DataSourceLocal
import com.example.translatortest.model.datasource.DataSourceRemote
import com.example.translatortest.model.repository.RepositoryImplementation
import com.example.translatortest.view.BaseViewModel
import io.reactivex.observers.DisposableObserver

class MainViewModel(
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImplementation(DataSourceRemote()),
        RepositoryImplementation(DataSourceLocal())
    )
): BaseViewModel<AppState>() {

    private var appState: AppState? = null

    override fun getData(word: String, isOnline: Boolean): LiveData<AppState> {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe { liveDataForViewToObserve.value = (AppState.Loading(null)) }
                .subscribeWith(getObserver())
        )
        return super.getData(word, isOnline)
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onComplete() {

            }

            override fun onNext(state: AppState) {
                appState = state
                liveDataForViewToObserve.value = appState
            }


            override fun onError(e: Throwable) {
                liveDataForViewToObserve.value = AppState.Error(e)
            }
        }
    }
}