package com.example.coins.screens

import android.util.Log
import android.util.Range
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coins.components.Combobox
import com.example.coins.components.MultiCombobox
import com.example.coins.data.Option
import com.maxkeppeker.sheets.core.models.base.ButtonStyle
import com.maxkeppeker.sheets.core.models.base.SelectionButton
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarView
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import java.time.LocalDate
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FiltersScreen(onNavigateToHistory: () -> Unit) {
    val periodOptions = listOf(
        Option(id = 1, label = "За все время"),
        Option(id = 2, label = "За неделю"),
        Option(id = 3, label = "За месяц"),
        Option(id = 4, label = "За период"),
    )
    var selectedPeriod by remember {
        mutableStateOf(periodOptions[0])
    }

    val selectedDateRange = remember {
        val value = Range(LocalDate.now(), LocalDate.now())
        mutableStateOf(value)
    }

    val currencyOptions = listOf(
        Option(id = 1, label = "RUB"),
        Option(id = 2, label = "USD"),
        Option(id = 3, label = "EUR"),
    )

    var selectedCurrencyList by remember {
        mutableStateOf(emptyList<Option>())
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
                Text(text = "Фильтры", fontSize = 20.sp)
            };
            MultiCombobox(
                label = "Выбор валют",
                options = currencyOptions,
                onChange = { selectedOptions ->
                    run {
                        selectedCurrencyList = selectedOptions
                    }
                    Log.d("selected", selectedOptions.toString())
                },
                value = selectedCurrencyList,
                placeholder = "Выберите валюты"
            )
            Combobox(
                label = "Выбор периода",
                options = periodOptions,
                onChange = { selectedItem ->
                    run {
                        selectedPeriod = selectedItem
                    }
                },
                value = selectedPeriod
            )
            if (selectedPeriod.id === 4) {
                CalendarView(
                    useCaseState = rememberUseCaseState(),
                    config = CalendarConfig(
                        style = CalendarStyle.MONTH,
                    ),
                    selection = CalendarSelection.Period(
                        selectedRange = selectedDateRange.value,
                        negativeButton = null,
                        positiveButton = SelectionButton(
                            text = "Подтвердить",
                            type = ButtonStyle.FILLED,
                        )
                    ) { startDate, endDate ->
                        selectedDateRange.value = Range(startDate, endDate)
                    },
                )
            }
            Button(
                onClick = { onNavigateToHistory() }
            ) {
                Text(text = "Применить")
            }
        }
    }
}