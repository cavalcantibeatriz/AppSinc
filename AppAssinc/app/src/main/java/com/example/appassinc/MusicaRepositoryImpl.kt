package com.example.appassinc

import retrofit2.Response

class MusicaRepositoryImpl: IMusicaRepository {
    override suspend fun getAll(): Response<List<Musica>> {
        val api = ApiConfig
            .getIntance()
            .create(MusicaService::class.java)
        return api.getAll()

    }
}