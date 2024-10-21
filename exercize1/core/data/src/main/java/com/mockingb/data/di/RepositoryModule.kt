package com.mockingb.data.di

import com.mockingb.data.repository.CompaniesApiDataRepository
import com.mockingb.data.repository.CompaniesDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyDataRepository(
        companiesApiDataRepository: CompaniesApiDataRepository
    ): CompaniesDataRepository
}