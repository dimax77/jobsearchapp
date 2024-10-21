package com.mockingb.myapplication.ui.companies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.hilt.navigation.compose.hiltViewModel
import com.mockingb.myapplication.ui.theme.blackV


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanyDetailScreen(viewModel: CompaniesViewModel) {
    val company = viewModel.selectedCompany
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = company!!.name, style = TextStyle(
//                        fontFamily = jsaFont,
                        color = Color.White,
//                        fontSize = 30.sp
                    )
                )
            }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(blackV))
        }
    ) {
        Column(Modifier.padding(it)) {
            Text(text = "Activity: ${company!!.activity}")
            var vacanciesList = ""
            company!!.vacancies.forEachIndexed { index, vacancy ->
                if (index > 0) vacanciesList += ", "
                vacanciesList += vacancy
            }
            Text(text = "Vacancies: $vacanciesList")
            var contactsList = ""
            viewModel.selectedCompany!!.contacts.forEachIndexed { index, contact ->
                if (index > 0) contactsList += ", "
                contactsList += "$contact"
            }
            Text(text = "Contacts: $contactsList")

        }
    }
}