package com.example.bluemoney.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bluemoney.ui.screens.shop.ShopItem
import com.example.bluemoney.ui.screens.welcome.Welcome

class BlueMoneyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { Welcome(navController) }
        composable("shopItem") {
            val viewModel: BlueMoneyViewModel = viewModel()
            val context = LocalContext.current
            ShopItem(viewModel, context)
        }
    }
}