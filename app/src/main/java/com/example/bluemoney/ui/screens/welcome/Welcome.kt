package com.example.bluemoney.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bluemoney.R
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bluemoney.main.BlueMoneyViewModel
import com.example.bluemoney.ui.screens.shop.ShopItem

@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
}


@Composable
fun Welcome(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(53.dp),
            modifier = Modifier
                .height(560.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bm_logo),
                contentDescription = "App Logo Icon",
                modifier = Modifier
                    .padding(top = 54.dp)
                    .offset(x = 0.dp, y = 0.dp)
                    .size(205.dp),
            )
            Text(
                color = Color.Gray,
                text = stringResource(id = R.string.app_slogan),
                fontSize = 16.sp,
                modifier = Modifier
                    .offset(x = 0.dp, y = (-50).dp)

            )
            Button(
                onClick = { navController.navigate("shopItem") },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xff000080)),
                modifier = Modifier
                    .width(350.dp)
                    .offset(x = 0.dp, y = (-50).dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Text(
                        text = stringResource(id = R.string.start_text),
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.White,
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, end = 10.dp)
                    )
                }
            }
        }
    }
}
