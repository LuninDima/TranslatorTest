package com.example.translatortest.model.repository

import com.example.translatortest.model.data.DataModel
import com.example.translatortest.model.datasource.DataSource
import com.example.translatortest.model.repository.Repository
import io.reactivex.Observable

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>):
    Repository<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        return  dataSource.getData(word)
    }
}