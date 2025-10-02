package com.spaceiscool.pictureoftheday

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spaceiscool.data.model.APOD
import com.spaceiscool.data.repository.NasaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface APODUiState {
    data object Loading : APODUiState
    data class Success(val apod: APOD) : APODUiState
    data class Error(val message: String) : APODUiState
}

@HiltViewModel
class APODViewModel @Inject constructor(
    private val nasaRepository: NasaRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<APODUiState>(APODUiState.Loading)
    val uiState: StateFlow<APODUiState> = _uiState

    init {
        getPhotoOfTheDay()
    }

    private fun getPhotoOfTheDay() {
        viewModelScope.launch {
            nasaRepository.getAPOD
                .catch { e -> _uiState.value = APODUiState.Error(e.message ?: "An unknown error occurred") }
                .collect { apod -> _uiState.value = APODUiState.Success(apod) }
        }
    }
}
