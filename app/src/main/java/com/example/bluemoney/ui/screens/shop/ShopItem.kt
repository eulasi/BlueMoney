package com.example.bluemoney.ui.screens.shop

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bluemoney.main.BlueMoneyViewModel
import com.example.bluemoney.R
import com.paypal.android.cardpayments.CardClient

@Preview(showBackground = true)
@Composable
fun ShopItemPreview() {
}

@Composable
fun ShopItem(viewModel: BlueMoneyViewModel, context: Context) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,

        modifier = Modifier
            .fillMaxWidth()
            .height(780.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.nothing_item), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(500.dp)
                .width(500.dp)
                .padding(start = 12.dp, top = 48.dp, end = 18.dp, bottom = 18.dp)
                .clip(shape = RoundedCornerShape(6.dp))
                .align(Alignment.CenterHorizontally)
        )
        Box(
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 24.dp, top = 24.dp)
                .shadow(12.dp, shape = RoundedCornerShape(34.dp))
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(shape = CircleShape)
                    .background(Color.LightGray)
            )
            {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "null",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(22.dp)
                )
            }
        }
        Column {
            Text(
                text = "A Whole Lot of Nothing",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 26.dp, start = 24.dp)
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = stringResource(R.string.product_description),
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, top = 20.dp)
            )
            Spacer(modifier = Modifier.width(2.dp))
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(130.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(16.dp)),
        ) {
            Column(
                modifier = Modifier
                    .padding(22.dp),
            ) {
                Text(
                    text = "Total",
                    color = Color.Gray
                )
                Text(
                    text = "Amount",
                    color = Color.Gray
                )
            }
            Text(
                text = "$99",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 22.dp, bottom = 22.dp)
            )
            Button(
                //TODO: Apply  On Click
                onClick = {
                    viewModel.approveOrder(context)
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xff000080)),
                modifier = Modifier
                    .width(150.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Text(
                        text = stringResource(id = R.string.buy_now),
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.White,
                        modifier = Modifier
                            .padding(top = 8.dp, bottom = 8.dp)
                    )
                }
            }
        }
    }
}

