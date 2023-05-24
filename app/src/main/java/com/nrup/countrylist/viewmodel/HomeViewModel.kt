package com.nrup.countrylist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nrup.countrylist.domain.model.countrylist.CountryListResponse
import com.nrup.countrylist.domain.repository.CountryRepository
import com.nrup.countrylist.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val countryRepository: CountryRepository
) : ViewModel() {

    // ======== COUNTRY LIST

    // For swipe to refresh
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _countryListState =
        MutableStateFlow<Response<CountryListResponse>>(Response.Success(null))
    val countryListState: StateFlow<Response<CountryListResponse>> = _countryListState.asStateFlow()

    fun getCountryList() {
        viewModelScope.launch {
            _isLoading.value = true
            countryRepository.getAllCountries().collect { response ->
                _countryListState.value = response
                _isLoading.value = false
            }
        }
    }

    // Load country list when VM created
    init {
        getCountryList()
    }

}