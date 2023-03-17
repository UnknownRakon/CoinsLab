package com.example.coins.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(onNavigateToConverter: () -> Unit) {
    val itemsList = listOf(
        "RUB",
        "EUR",
        "USD",
        "RUB",
        "EUR",
        "USD",
        "RUB",
        "EUR",
        "USD",
        "USD",
        "RUB",
        "EUR",
        "USD"
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
                .padding(top = 10.dp), horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Избранное", fontSize = 20.sp)
        };
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(items = itemsList, itemContent = { item ->
                Box(
                    modifier = Modifier
                        .height(35.dp)
                        .clip(CircleShape)
                        .background(Color.Blue.copy(alpha = 0.3f))

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(horizontal = 15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Text(
                            item,
                            fontSize = 16.sp,
                            color = Color.White,
                            fontWeight = FontWeight(500)
                        )
                    }

                }
            }
            )
        };
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Доступные валюты", fontSize = 20.sp)
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(items = itemsList, itemContent = { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(Color.LightGray.copy(alpha = 0.1f))
                        .combinedClickable(
                            onClick = onNavigateToConverter,
                            onLongClick = {
                                println("long")
                                onNavigateToConverter()
                            }
                        )

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .padding(horizontal = 25.dp, vertical = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            item,
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontWeight = FontWeight(500)
                        );
                        Icon(
                            Icons.Rounded.Star,
                            contentDescription = "add to favorite",
                        )
                    }

                }
            }
            )
        }
    }
}