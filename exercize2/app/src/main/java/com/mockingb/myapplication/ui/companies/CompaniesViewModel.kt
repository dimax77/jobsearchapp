package com.mockingb.myapplication.ui.companies

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mockingb.data.repository.CompaniesDataRepository
import com.mockingb.model.Company
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompaniesViewModel @Inject constructor(private val repository: CompaniesDataRepository) :
    ViewModel() {
    private val _companies = MutableStateFlow<List<Company>>(emptyList())
    val companies: StateFlow<List<Company>> = _companies

    var selectedCompany by mutableStateOf<Company?>(null)
        private set

    fun selectedCompany(company: Company, callBack: () -> Unit) {
        viewModelScope.launch {
            selectedCompany = company
            Log.d("Company View Model", "Company selected: ${company.vacancies}")
            callBack()
        }
    }

    private fun fetchCompaniesList() {
        viewModelScope.launch {
            _companies.value = repository.getAllCompanies()
        }
    }

    init {
        fetchCompaniesList()
    }
}