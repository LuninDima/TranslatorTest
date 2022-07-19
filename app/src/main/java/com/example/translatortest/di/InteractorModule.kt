package com.example.translatortest.di

import com.example.translatortest.model.data.DataModel
import com.example.translatortest.model.repository.Repository
import com.example.translatortest.view.main.MainInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class InteractorModule {
    @Provides
    internal fun provideIneteractor(
        @Named(NAME_REMOTE)  remoteRepository: Repository<List<DataModel>>,
      @Named(NAME_LOCALE)  localRepository: Repository<List<DataModel>>
    ): MainInteractor{
        return MainInteractor(remoteRepository, localRepository)
    }
}