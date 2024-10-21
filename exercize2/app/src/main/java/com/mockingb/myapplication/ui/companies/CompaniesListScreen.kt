package com.mockingb.myapplication.ui.companies

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mockingb.model.Company
import com.mockingb.myapplication.ui.theme.blackV
import com.mockingb.myapplication.ui.theme.blueV
import com.mockingb.myapplication.ui.theme.jsaFont


@Composable
fun CompaniesList(
    navigateToCompanyDetail: () -> Unit, viewModel: CompaniesViewModel
) {
    val companies by viewModel.companies.collectAsState(emptyList())
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .background(blackV)
            .fillMaxSize()
    ) {
        items(companies) {
            CompanyCard(navigateToCompanyDetail, viewModel, it)
        }
    }
}

@Composable
private fun CompanyCard(
    navigateToCompanyDetail: () -> Unit, viewModel: CompaniesViewModel, company: Company
) {
    Box(
        Modifier
            .height(100.dp)
            .background(Color.Transparent)
            .padding(horizontal = 6.dp)
            .clickable {
                viewModel.selectedCompany(company, navigateToCompanyDetail)

            }, contentAlignment = Alignment.Center) {
        Box(
            Modifier
                .background(blueV)
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .align(Alignment.BottomCenter)
        ) {
            Column {
                Text(
                    text = company.name, maxLines = 1, style = TextStyle(
                        fontSize = 50.sp,
                        letterSpacing = 20.sp,
                        color = Color.White,
                        fontFamily = jsaFont
                    ), modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = company.activity.name, maxLines = 1, style = TextStyle(
                        fontSize = 25.sp,
                        letterSpacing = 10.sp,
                        color = Color.White,
                        fontFamily = jsaFont
                    ), modifier = Modifier.align(Alignment.End)
                )
            }
            Box(modifier = Modifier
                .background(Color.Blue)
                .fillMaxHeight(0.1f)
                .align(Alignment.TopEnd)) {
                Column {
                    Text("Subscription is open", style = TextStyle(color = Color.White))
                }
            }
        }
    }
}
