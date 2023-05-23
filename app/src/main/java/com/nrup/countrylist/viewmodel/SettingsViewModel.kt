package com.nrup.countrylist.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.nrup.countrylist.domain.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val countryRepository: CountryRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

}