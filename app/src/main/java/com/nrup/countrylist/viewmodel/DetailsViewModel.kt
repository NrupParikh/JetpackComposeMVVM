package com.nrup.countrylist.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nrup.countrylist.domain.model.countrylist.CountryData
import com.nrup.countrylist.domain.repository.CountryRepository
import com.nrup.countrylist.utils.Const.ARG_COUNTRY_CODE
import com.nrup.countrylist.utils.Const.ARG_COUNTRY_NAME
import com.nrup.countrylist.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val countryRepository: CountryRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    // No need to use View Model Factory for sending parameter in VM.
    // Getting Argument from SavedStateHandle in VM with the help of nav arg

    private val countryCode = checkNotNull(savedStateHandle.get<String>(ARG_COUNTRY_CODE))
    private val countryName = checkNotNull(savedStateHandle.get<String>(ARG_COUNTRY_NAME))

    // ======== COUNTRY DETAILS

    private val _countryDetailsState =
        mutableStateOf<Response<CountryData>>(Response.Success(null))

    val countryDetailsState: State<Response<CountryData>> = _countryDetailsState

    fun getCountryDetails() {
        viewModelScope.launch {
            countryRepository.getCountryDetails(countryCode).collect { response ->
                _countryDetailsState.value = response
            }
        }
    }

    // Load Country Details when VM Created
    init {
        Log.d("TAG","Country Code $countryCode")
        Log.d("TAG","Country Name $countryName")
        getCountryDetails()
    }
}