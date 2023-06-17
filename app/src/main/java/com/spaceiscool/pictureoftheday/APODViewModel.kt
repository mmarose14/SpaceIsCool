package com.spaceiscool.pictureoftheday

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spaceiscool.data.model.APOD
import com.spaceiscool.data.repository.NasaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class APODViewModel @Inject constructor(
    private val nasaRepository: NasaRepository
): ViewModel() {
    private var _errorMessage = MutableLiveData<String>()
    val errorMessage get() = _errorMessage

    private var _apod = MutableLiveData<APOD>()
    val apod get() = _apod

    fun getPhotoOfTheDay() {
        viewModelScope.launch {
            nasaRepository.getAPOD
                .catch { e -> _errorMessage.value = e.message }
                .collect { _apod.value = it }
        }
    }
}