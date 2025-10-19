package com.mcajusol.pc01.presentation.auth.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mcajusol.pc01.presentation.auth.LoginScreen

@Composable
fun AppNavGraph(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login")
    {
        composable("login") { LoginScreen(navController) }

        composable("home") {
           // DrawerScaffold(navController) {
                HomeScreen()
          //  }
        }
    }
}