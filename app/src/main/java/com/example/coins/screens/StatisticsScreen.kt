package com.example.coins.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coins.components.MySelect
import com.example.coins.data.Option
import com.himanshoe.charty.common.dimens.ChartDimens
import com.himanshoe.charty.line.CurveLineChart
import com.himanshoe.charty.line.LineChart
import com.himanshoe.charty.line.model.LineData

@Composable
fun StatisticsScreen() {
    val currencyOptions = listOf(
        Option(id = 1, label = "RUB"),
        Option(id = 2, label = "USD"),
        Option(id = 3, label = "EUR"),
    )
    var selectedCurrency by remember {
        mutableStateOf(currencyOptions[0])
    }
    var charData by remember {
        mutableStateOf(
            listOf(
                LineData(xValue = "Пн", yValue = 2f),
                LineData(xValue = "Вт", yValue = 1f),
                LineData(xValue = "Ср", yValue = 2f),
                LineData(xValue = "Чт", yValue = 5f),
                LineData(xValue = "Пт", yValue = 4f),
                LineData(xValue = "Cб", yValue = 6f),
                LineData(xValue = "Вс", yValue = 0f)
            )
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 60.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp), horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Аналитика", fontSize = 20.sp)
            };
            MySelect(
                label = "Выбор валюты",
                options = currencyOptions,
                onChange = { selectedItem ->
                    run {
                        selectedCurrency = selectedItem
                    }
                },
                value = selectedCurrency
            )
            LineChart(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 50.dp)
                    .fillMaxWidth()
                    .height(400.dp),
                color = MaterialTheme.colorScheme.primary,
                lineData = charData
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp), horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { charData = charData.slice(0..charData.size / 2 - 1) }) {
                    Text(text = "Hеделя")
                }
                Button(onClick = { charData = charData.plus(charData) }) {
                    Text(text = "2 Hедели")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Месяц")
                }
            };
        }
    }

}