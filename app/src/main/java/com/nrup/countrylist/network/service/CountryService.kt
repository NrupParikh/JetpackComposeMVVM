package com.nrup.countrylist.network.service

import com.nrup.countrylist.domain.model.countrylist.CountryData
import com.nrup.countrylist.domain.model.countrylist.CountryListResponse
import com.nrup.countrylist.utils.Const.METHOD_ALL_COUNTRY
import com.nrup.countrylist.utils.Const.METHOD_COUNTRY_DETAILS
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryService {

    @GET(METHOD_ALL_COUNTRY)
    suspend fun getAllCountries(): CountryListResponse

    @GET(METHOD_COUNTRY_DETAILS)
    suspend fun getCountryDetails(@Path("countryCode") countryCode: String): CountryData

}