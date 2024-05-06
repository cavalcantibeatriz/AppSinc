package com.example.appassinc

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coroutine.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.create

    val appModule = module{
        single <IMusicaRepository>{
            MusicaRepositoryImpl() // api
            LocalMusicaRepositoryImpl() //mockado
        }
        viewModel {
            MainViewModel(get())
        }
    }
