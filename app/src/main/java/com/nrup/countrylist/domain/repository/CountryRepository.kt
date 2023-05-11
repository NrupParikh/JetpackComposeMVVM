package com.nrup.countrylist.domain.repository

import com.nrup.countrylist.domain.model.CountryListResponse
import com.nrup.countrylist.utils.Response
import kotlinx.coroutines.flow.Flow

interface CountryRepository {
    fun getAllCountries(): Flow<Response<CountryListResponse>>
}