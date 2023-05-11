package com.nrup.countrylist.network.service

import com.nrup.countrylist.domain.model.CountryListResponse
import com.nrup.countrylist.utils.Const.METHOD_ALL_COUNTRY
import retrofit2.http.GET

interface CountryService {

    @GET(METHOD_ALL_COUNTRY)
    suspend fun getAllCountries(): CountryListResponse
}