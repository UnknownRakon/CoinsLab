package com.example.coins.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coins.R
import com.example.coins.data.ExchangeOperation
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun HistoryScreen() {
    val itemsList = listOf<ExchangeOperation>(
        ExchangeOperation(
            firstCurrency = com.example.coins.data.Currency(id = 1, name = "EUR"),
            firstCurrencyAmount = 12,
            secondCurrency = com.example.coins.data.Currency(id = 2, name = "RUB"),
            secondCurrencyAmount = 120,
            date = LocalDateTime.now()
        ),
        ExchangeOperation(
            firstCurrency = com.example.coins.data.Currency(id = 1, name = "EUR"),
            firstCurrencyAmount = 15,
            secondCurrency = com.example.coins.data.Currency(id = 2, name = "RUB"),
            secondCurrencyAmount = 150,
            date = LocalDateTime.now()
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 60.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "История обменов", fontSize = 20.sp)
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painterResource(id = R.drawable.filters),
                    contentDescription = "filters",
                    modifier = Modifier
                        .padding(5.dp)
                        .size(20.dp),
                    tint = MaterialTheme.colors.primary.copy(alpha = 0.6f)
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(items = itemsList, itemContent = { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(Color.LightGray.copy(alpha = 0.1f))
                ) {
                    Column(
                        modifier = Modifier.padding(vertical = 6.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                item.date.format(
                                    DateTimeFormatter.ofPattern(
                                        "dd MMMM yyyy",
                                        Locale("ru", "RU")
                                    )
                                ),
                                fontSize = 16.sp,
                                color = Color.Black,
                                fontWeight = FontWeight(500)
                            );
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                "${item.firstCurrencyAmount} ${item.firstCurrency.name}",
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontWeight = FontWeight(500)
                            );
                            Icon(
                                Icons.Rounded.ArrowForward,
                                contentDescription = "to",
                                modifier = Modifier
                                    .padding(5.dp)
                                    .size(16.dp)
                            )
                            Text(
                                "${item.secondCurrencyAmount} ${item.secondCurrency.name}",
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontWeight = FontWeight(500)
                            );
                        }
                    }
                }
            }
            )
        }
    }

}