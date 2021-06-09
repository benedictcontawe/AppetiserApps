package com.example.appetiserapps

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


object ApplicationModule {

    val applicationModule : Module = module {

        single<BaseRepository> {
            provideCustomRepository(get<ITunesAPI>())
        }

        viewModel {
            provideMainViewModel(get<BaseRepository>())
        }

    }

    private fun provideMainViewModel(baseRepository : BaseRepository) : MainViewModel = MainViewModel()

    private fun provideCustomRepository(iTunesAPI : ITunesAPI) : BaseRepository {
        return Repository(iTunesAPI)
    }
}