package com.nrup.countrylist.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nrup.countrylist.domain.model.CountryListResponse
import com.nrup.countrylist.domain.repository.CountryRepository
import com.nrup.countrylist.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val countryRepository: CountryRepository
) : ViewModel() {

    private val _countryListState =
        mutableStateOf<Response<CountryListResponse>>(Response.Success(null))
    val countryListState: State<Response<CountryListResponse>> = _countryListState

    fun getCountryList() {
        viewModelScope.launch {
            countryRepository.getAllCountries().collect { response ->
                _countryListState.value = response
            }
        }
    }
}