package com.example.coins.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.coins.data.Option

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySelect(
    label: String,
    options: List<Option>,
    onChange: (selectedItem: Option) -> Unit,
    value: Option
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
            value = value.label,
            onValueChange = {},
            label = { Text(label) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )

        // menu
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            // this is a column scope
            // all the items are added vertically
            options.forEach { selectedOption ->
                // menu item
                DropdownMenuItem(
                    text = {
                        Text(text = selectedOption.label)
                    },
                    onClick = {
                        onChange(selectedOption)
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}