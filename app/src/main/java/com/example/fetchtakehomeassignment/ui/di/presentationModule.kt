package com.example.fetchtakehomeassignment.ui.di

import com.example.fetchtakehomeassignment.domain.usecase.GetListItemsSortedUseCase
import com.example.fetchtakehomeassignment.ui.viewmodels.ListItemsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    // use-case
    single<GetListItemsSortedUseCase> { GetListItemsSortedUseCase(get()) }

    // viewmodel
    viewModel<ListItemsViewModel> { ListItemsViewModel(get()) }
}
