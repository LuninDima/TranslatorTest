package com.example.translatortest.view.base

import com.example.translatortest.model.data.AppState

interface View {
    fun renderData(appState: AppState)
}

