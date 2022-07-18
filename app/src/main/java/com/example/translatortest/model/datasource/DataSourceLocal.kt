package com.example.translatortest.model.datasource

import com.example.translatortest.model.data.DataModel
import io.reactivex.Observable

class DataSourceLocal(
    private val remoteProvider: RoomDataBaseImplementation =
        RoomDataBaseImplementation()
) : DataSource<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        return remoteProvider.getData(word)
    }
}