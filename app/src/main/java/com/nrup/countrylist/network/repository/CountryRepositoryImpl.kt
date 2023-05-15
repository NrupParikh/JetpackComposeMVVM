package com.nrup.countrylist.network.repository

import com.nrup.countrylist.domain.model.countrylist.CountryData
import com.nrup.countrylist.domain.model.countrylist.CountryListResponse
import com.nrup.countrylist.domain.repository.CountryRepository
import com.nrup.countrylist.network.service.CountryService
import com.nrup.countrylist.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryRepositoryImpl @Inject constructor(
    private val countryService: CountryService
) : CountryRepository {
    override fun getAllCountries(): Flow<Response<CountryListResponse>> = flow {

        try {
            emit(Response.Loading)
            val responseFromApi = countryService.getAllCountries()
            emit(Response.Success(responseFromApi))
        } catch (e: Exception) {
            emit(Response.Failure(e))
        }
    }.flowOn(Dispatchers.IO)

    override fun getCountryDetails(countryCode: String): Flow<Response<CountryData>> = flow {

        try {
            emit(Response.Loading)
            val responseFromApi = countryService.getCountryDetails(countryCode)
            emit(Response.Success(responseFromApi))
        } catch (e: Exception) {
            emit(Response.Failure(e))
        }
    }.flowOn(Dispatchers.IO)
}