package com.spaceiscool.neo

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spaceiscool.data.model.neo.NEO
import com.spaceiscool.data.model.neo.NearEarthObject
import com.spaceiscool.data.repository.NasaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NEOViewModel @Inject constructor(
    private val nasaRepository: NasaRepository
): ViewModel() {

    private var _errorMessage = MutableLiveData<String>()
    val errorMessage get() = _errorMessage

    private var _neo = MutableLiveData<NEO>()
    val neo get() = _neo

    fun getNeoBrowse() {
        viewModelScope.launch {
            nasaRepository.getNEO
                .catch { e ->
                    Timber.e(e)
                    _errorMessage.value = e.message
                }
                .collect {
                    _neo.value = it
                }
        }
    }

    fun getNeoURL(neo: NearEarthObject): String {
        val uriBuilder = Uri.Builder()

        //Have to do hacky stuff to get the lookup on NASA site to work correctly
        val nameDesignation = "${neo.designation} ${neo.name_limited}"

        uriBuilder.scheme("https")
            .authority("ssd.jpl.nasa.gov")
            .appendPath("tools")
            .appendPath("sbdb_lookup.html#/")
            .appendQueryParameter("sstr", nameDesignation)

        val encodedUrl = uriBuilder.build().toString()
        val decodeUrl = Uri.decode(encodedUrl)
        return decodeUrl
    }
}