package com.sportscan.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.ArrowDropUp
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.Timeline
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sportscan.ui.screens.Profile

@Composable
fun InputProfileField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    label: String,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        textStyle = TextStyle(fontSize = 18.sp),
        placeholder = { Text(text = placeholder) },
        label = { Text(text = label) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectionExposedDropField(
    isExpanded: Boolean,
    onExpansionChange: (Boolean) -> Unit,
    options: List<String>,
    selectedOption: String,
    onSelectionChange: (String) -> Unit,
    icon: ImageVector
) {

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = onExpansionChange,
    ) {
        TextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.menuAnchor(type = MenuAnchorType.PrimaryEditable, enabled = true),
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    tint = Color.Blue
                )
            },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        )
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { onExpansionChange(false) }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        onSelectionChange(selectionOption)
                        onExpansionChange(false)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CostOfLesson(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    label: String
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("per/") }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        textStyle = TextStyle(fontSize = 18.sp),
        placeholder = { Text(text = placeholder) },
        label = { Text(text = label) },
        leadingIcon = { Icon(imageVector = Icons.Rounded.Money, contentDescription = "") },
        trailingIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = selectedOption,
                    fontSize = 12.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.End,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                IconButton(onClick = { expanded = true }) {
                    if (expanded) {
                        Icon(imageVector = Icons.Rounded.ArrowDropUp, contentDescription = "")
                    } else {
                        Icon(imageVector = Icons.Rounded.ArrowDropDown, contentDescription = "")
                    }
                }
            }

        }
    )


    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = MenuDefaults.TonalElevation,
        border = BorderStroke(1.dp, Color.Yellow),
    ) {

        DropdownMenuItem(
            onClick = { selectedOption = "Hour" },
            text = { Text("Hour") }
        )
        HorizontalDivider()
        DropdownMenuItem(
            onClick = { selectedOption = "Day" },
            text = { Text("Day") }
        )
        HorizontalDivider()
        DropdownMenuItem(
            onClick = { selectedOption = "Week" },
            text = { Text("Week") }
        )
        HorizontalDivider()
        DropdownMenuItem(
            onClick = { selectedOption = "Month" },
            text = { Text("Month") }
        )
        HorizontalDivider()
        DropdownMenuItem(
            onClick = { selectedOption = "Year" },
            text = { Text("Year") }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkGraphic(
    isExpanded: Boolean,
    onExpansionChange: (Boolean) -> Unit,
    options: List<String>,
    value: String,
    onGraphicChange: (String) -> Unit
) {
    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = onExpansionChange
    ) {
        TextField(
            value = value,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .menuAnchor(type = MenuAnchorType.PrimaryEditable, enabled = true),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Timeline,
                    contentDescription = "",
                    tint = Color.Blue
                )
            },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 14.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.End
            )
        )

        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { onExpansionChange(false) }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        onGraphicChange(selectionOption)
                        onExpansionChange(false)
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    Profile(navigateTo = {})
}