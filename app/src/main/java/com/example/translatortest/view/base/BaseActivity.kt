package com.example.translatortest.view.base

import androidx.appcompat.app.AppCompatActivity
import com.example.translatortest.model.data.AppState
import com.example.translatortest.view.BaseViewModel

abstract class BaseActivity<T : AppState> : AppCompatActivity() {

    abstract fun renderData(appState: AppState)
    abstract val model: BaseViewModel<T>






}