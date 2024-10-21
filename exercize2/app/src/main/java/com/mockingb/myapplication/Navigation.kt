package com.mockingb.myapplication

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mockingb.myapplication.ui.MainScreen
import com.mockingb.myapplication.ui.companies.CompaniesViewModel
import com.mockingb.myapplication.ui.companies.CompanyDetailScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val sharedViewModel: CompaniesViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = "main screen") {
        composable("main screen") {
            MainScreen({ navController.navigate("company's detail") }, sharedViewModel)
        }
        composable("company's detail") {
            CompanyDetailScreen(sharedViewModel)
        }
    }
}