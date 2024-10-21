package com.mockingb.data.repository

import android.util.Log
import com.mockingb.model.Company
import com.mockingb.network.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CompaniesApiDataRepository @Inject constructor(private val apiService: ApiService) :
    CompaniesDataRepository {
    override suspend fun getAllCompanies(): List<Company> {
        return try {
            apiService.getAllCompanies()
        } catch (e: Exception) {
            Log.d("CompanyApiDataRepository", e.toString())
            emptyList()
        }
    }

}