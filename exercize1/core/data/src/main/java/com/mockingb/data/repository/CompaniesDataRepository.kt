package com.mockingb.data.repository

import com.mockingb.model.Company

interface CompaniesDataRepository {
    suspend fun getAllCompanies(): List<Company>
}