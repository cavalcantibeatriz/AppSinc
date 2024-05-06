package com.example.coroutine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appassinc.ApiConfig
import com.example.appassinc.IMusicaRepository
import com.example.appassinc.MainScreenState
import com.example.appassinc.MusicaService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.create

class MainViewModel(
    private val repository:IMusicaRepository
) : ViewModel() {

    var state = MutableLiveData<MainScreenState>(MainScreenState.Loading)
        private set
    fun getAllMusicas() {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                val response = repository.getAll()
                if (response.isSuccessful) {
                    val list = response.body() ?: emptyList()
                    state.value = MainScreenState.Success(data = list)
                } else {
                    // TODO: Deveria tratar, lançar um erro mais específico ...
                    throw Exception("Erro desconhecido")
                }
            } catch (e: HttpException) {
                val message = when (e.code()) {
                    400 -> "Música não encontrada"
                    404 -> "Parâmetros incorretos"
                    else -> "Erro desconhecido"
                }
                state.value = MainScreenState.Error(message)
            } catch (e: Exception) {
                state.value = MainScreenState.Error(
                    e.message ?: "Erro desconhecido"
                )
            }
        }
    }

}