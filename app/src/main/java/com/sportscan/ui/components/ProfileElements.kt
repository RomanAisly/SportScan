package com.sportscan.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.Timeline
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.sp
import com.sportscan.ui.screens.Profile


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectionField(
    modifier: Modifier = Modifier,
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
        modifier = modifier
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
fun CostOfLessonField(
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
    onExpansionChange: (Boolean) -> Unit,
    options: List<String>,
    value: String, //may need 1 more value
    onValueChange: (String) -> Unit,
    onMoneyChange: (String) -> Unit
) {

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = onExpansionChange,
        modifier = modifier
    ) {

        TextField(
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            placeholder = { Text(text = "Enter the cost") }

        )
        TextField(
            value = value,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.menuAnchor(type = MenuAnchorType.PrimaryEditable, enabled = true),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Money,
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
                        onMoneyChange(selectionOption)
                        onExpansionChange(false)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkGraphic(
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
    onExpansionChange: (Boolean) -> Unit,
    options: List<String>,
    fromHour: String,
    toHour: String,
    value: String,
    fromHourChange: (String) -> Unit,
    toHourChange: (String) -> Unit,
    onGraphicChange: (String) -> Unit
) {
    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = onExpansionChange,
        modifier = modifier
    ) {
        TextField(
            value = fromHour,
            onValueChange = fromHourChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            placeholder = { Text(text = "FROM") },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 18.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.End
            )
        )

        TextField(
            value = toHour,
            onValueChange = toHourChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            placeholder = { Text(text = "TO") },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 18.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.End
            )
        )

        TextField(
            value = value,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.menuAnchor(type = MenuAnchorType.PrimaryEditable, enabled = true),
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