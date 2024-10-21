package com.mockingb.network

import com.mockingb.model.Company
import retrofit2.http.GET

interface ApiService {
    @GET("companies")
    suspend fun getAllCompanies() :List<Company>
}