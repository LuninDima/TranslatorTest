package com.example.translatortest.presenter

import com.example.translatortest.model.data.AppState
import com.example.translatortest.view.base.View

interface Presenter<T : AppState, V : View> {
    fun attachView(view: V)

    fun detachView(view: V)

    // Получение данных с флагом isOnline(из Интернета или нет)
    fun getData(word: String, isOnline: Boolean)
}