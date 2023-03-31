package com.example.coins.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.coins.data.Option

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiCombobox(
    label: String,
    placeholder: String,
    options: List<Option>,
    onChange: (selectedItems: List<Option>) -> Unit,
    value: List<Option>
) {
    // state of the menu
    var expanded by remember {
        mutableStateOf(false)
    }

    // box
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        // text field
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = value.joinToString { it.label },
            onValueChange = {},
            label = { Text(label) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            placeholder = { Text(text = placeholder) },
        )

        // menu
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            // this is a column scope
            // all the items are added vertically
            options.forEach { selectedOption ->
                val isChecked = value.any { it.id == selectedOption.id }
                val contentColor =
                    if (isChecked) Color.Blue else Color.Black
                DropdownMenuItem(
                    text = {
                        Text(text = selectedOption.label, color = contentColor)
                    },
                    onClick = {
                        if (isChecked) {
                            val newValue = value.filter { it.id != selectedOption.id }
                            onChange(newValue)
                        } else {
                            val newValue = value.toMutableList()
                            newValue.add(selectedOption)
                            onChange(newValue)
                        }
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}