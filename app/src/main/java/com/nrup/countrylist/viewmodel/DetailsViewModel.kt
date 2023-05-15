package com.nrup.countrylist.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nrup.countrylist.domain.model.countrylist.CountryData
import com.nrup.countrylist.domain.repository.CountryRepository
import com.nrup.countrylist.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val countryRepository: CountryRepository
) : ViewModel() {

    // ======== COUNTRY DETAILS

    private val _countryDetailsState =
        mutableStateOf<Response<CountryData>>(Response.Success(null))

    val countryDetailsState: State<Response<CountryData>> = _countryDetailsState

    fun getCountryDetails(countryCode: String) {
        viewModelScope.launch {
            countryRepository.getCountryDetails(countryCode).collect { response ->
                _countryDetailsState.value = response
            }
        }
    }
}