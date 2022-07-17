package com.example.translatortest.model.datasource

import com.example.translatortest.model.data.DataModel
import com.example.translatortest.model.datasource.DataSource
import io.reactivex.Observable

class RoomDataBaseImplementation: DataSource<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("Not yet implemented")
    }
}