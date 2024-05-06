package com.example.appassinc

import retrofit2.Response
import retrofit2.http.GET

interface MusicaService {
    @GET("/musicas")
    suspend fun getAll():Response<List<Musica>>
}