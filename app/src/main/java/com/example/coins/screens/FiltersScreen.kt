package com.example.coins.screens

import android.util.Range
import android.widget.CalendarView
import android.widget.DatePicker
import com.example.coins.components.MySelect
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
import com.example.coins.data.Option
import com.maxkeppeker.sheets.core.models.base.ButtonStyle
import com.maxkeppeker.sheets.core.models.base.SelectionButton
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
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
            MySelect(
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