package com.example.fetchtakehomeassignment.data.di

import com.example.fetchtakehomeassignment.data.remote.ListItemsService
import com.example.fetchtakehomeassignment.data.repository.ListItemsRepoImpl
import com.example.fetchtakehomeassignment.data.util.RetrofitClient
import com.example.fetchtakehomeassignment.domain.repository.ListItemsRepo
import org.koin.dsl.module

val dataModule = module {
    single<ListItemsService> { RetrofitClient.retrofit.create(ListItemsService::class.java) }
    single<ListItemsRepo> { ListItemsRepoImpl(get()) }
}