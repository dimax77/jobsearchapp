package com.mockingb.myapplication.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mockingb.myapplication.ui.companies.CompaniesList
import com.mockingb.myapplication.ui.companies.CompaniesViewModel
import com.mockingb.myapplication.ui.theme.blackV
import com.mockingb.myapplication.ui.theme.jsaFont
import com.mockingb.myapplication.ui.theme.redV
import com.mockingb.myapplication.ui.vacancies.VacanciesScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navigateToCompanyDetail: () -> Unit, viewModel: CompaniesViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Job Search Application", style = TextStyle(
                        fontFamily = jsaFont,
                        color = Color.White,
                        fontSize = 30.sp
                    )
                )
            }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(blackV))
        }
    ) {
        TabScreen(modifier = Modifier.padding(it), navigateToCompanyDetail, viewModel)
    }
}

@Composable
private fun TabScreen(
    modifier: Modifier = Modifier,
    navigateToCompanyDetail: () -> Unit,
    viewModel: CompaniesViewModel
) {
    var currentPage by remember { mutableIntStateOf(0) }
    val tabs = listOf("Companies", "Vacancies")

    Column(modifier = modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = currentPage,
            contentColor = redV,
            containerColor = blackV,
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[currentPage]),
                    content = {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(redV)
                                .height(5.dp)
                                .align(Alignment.BottomCenter)
                        )
                    }
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selectedContentColor = redV,
                    text = {
                        Text(
                            text = title,
                            style = TextStyle(fontSize = 20.sp, fontFamily = jsaFont)
                        )
                    },
                    selected = currentPage == index,
                    onClick = { currentPage = index },
                    icon = {
                        when (index) {
                            0 -> Icon(imageVector = Icons.Default.Home, contentDescription = null)
                            1 -> Icon(imageVector = Icons.Default.Person, contentDescription = null)
                        }
                    })
            }
        }
        when (currentPage) {
            0 -> CompaniesList(navigateToCompanyDetail, viewModel)
            1 -> VacanciesScreen()
        }
    }
}
