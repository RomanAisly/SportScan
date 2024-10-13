package com.sportscan.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.ArrowDropUp
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
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sportscan.R
import com.sportscan.ui.screens.Profile
import com.sportscan.ui.theme.darkYellow

@Composable
fun InputProfileField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    val maxChar = 300
    val focusManager = LocalFocusManager.current

    TextField(
        value = value,
        onValueChange = { if (it.length <= maxChar) onValueChange(it) },
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
        textStyle = TextStyle(fontSize = 18.sp),
        placeholder = { Text(text = placeholder, fontSize = 12.sp) },
        label = { Text(text = label, fontSize = 15.sp, textAlign = TextAlign.Center) },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedField(
    options: List<String>,
    selectedOption: String,
    onSelectionChange: (String) -> Unit,
    icon: Painter,
    tint: Color = Color.Blue
) {
    var isExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = true },
    ) {
        TextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.menuAnchor(type = MenuAnchorType.PrimaryEditable, enabled = true),
            leadingIcon = {
                Icon(
                    painter = icon,
                    contentDescription = "",
                    tint = tint
                )
            },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )
        )
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        onSelectionChange(selectionOption)
                        isExpanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun CostOfLesson(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    label: String,
    costPeriod: String,
    onCostPeriodChange: (String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    TextField(
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
        textStyle = TextStyle(fontSize = 16.sp),
        placeholder = { Text(text = placeholder, fontSize = 12.sp) },
        label = { Text(text = label, fontSize = 15.sp) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.rubble_icon),
                contentDescription = "",
                tint = darkYellow
            )
        },
        trailingIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = costPeriod,
                    fontSize = 13.sp,
                    textAlign = TextAlign.End,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                IconButton(onClick = { isExpanded = true }) {
                    if (isExpanded) {
                        Icon(imageVector = Icons.Rounded.ArrowDropUp, contentDescription = "")
                    } else {
                        Icon(imageVector = Icons.Rounded.ArrowDropDown, contentDescription = "")
                    }
                }
            }

        }
    )
    DropdownMenu(
        expanded = isExpanded,
        onDismissRequest = { isExpanded = false },
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = MenuDefaults.TonalElevation,
        border = BorderStroke(1.dp, Color.Yellow),
    ) {

        DropdownMenuItem(
            onClick = {
                onCostPeriodChange("Hour")
                isExpanded = false
            },
            text = { Text("Hour") }
        )
        HorizontalDivider()
        DropdownMenuItem(
            onClick = {
                onCostPeriodChange("Day")
                isExpanded = false
            },
            text = { Text("Day") }
        )
        HorizontalDivider()
        DropdownMenuItem(
            onClick = {
                onCostPeriodChange("Week")
                isExpanded = false
            },
            text = { Text("Week") }
        )
        HorizontalDivider()
        DropdownMenuItem(
            onClick = {
                onCostPeriodChange("Month")
                isExpanded = false
            },
            text = { Text("Month") }
        )
        HorizontalDivider()
        DropdownMenuItem(
            onClick = {
                onCostPeriodChange("Year")
                isExpanded = false
            },
            text = { Text("Year") }
        )
    }
}


@Composable
fun RadioButtonsSelection(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onSelectionChange: (Boolean) -> Unit,
    text: String
) {
    Row(
        modifier = modifier
            .selectableGroup(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Start,
            color = MaterialTheme.colorScheme.onSurface,
        )
        RadioButton(
            selected = isSelected,
            onClick = {
                onSelectionChange(true)
            },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Green,
                unselectedColor = Color.Green
            )
        )
        Text(
            text = "Yes",
            textAlign = TextAlign.Start,
            color = Color.Green
        )

        RadioButton(
            selected = !isSelected,
            onClick = {
                onSelectionChange(false)
            },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Red
            )
        )
        Text(
            text = "No",
            textAlign = TextAlign.Start,
            color = Color.Red
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    Profile(navigateTo = {})
}