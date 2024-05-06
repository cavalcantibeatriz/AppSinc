package com.example.appassinc

import retrofit2.Response

interface IMusicaRepository {
    suspend fun getAll(): Response<List<Musica>>
}