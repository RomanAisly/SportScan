package com.sportscan.ui.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.ArrowDropUp
import androidx.compose.material3.Button
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sportscan.R
import com.sportscan.domain.helpers.UiText
import com.sportscan.ui.screens.Profile
import com.sportscan.ui.theme.authElements
import com.sportscan.ui.theme.darkYellow

@Composable
fun SectionPhoto(
    modifier: Modifier = Modifier,
    uriList: List<Uri> = emptyList(),
    onImagesSelected: (List<Uri>) -> Unit
) {

    val multiplePhotoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(),
        onResult = onImagesSelected)

    Column(
        modifier.wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(uriList.size) { index ->
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(uriList[index])
                        .crossfade(true).build(),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
        }
        Button(
            onClick = {
                multiplePhotoPicker.launch(
                    PickVisualMediaRequest(
                        ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                )
            }) {
            Text(text = stringResource(R.string.pick_images_button))
        }
    }
}


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
    options: List<UiText.StringResource>,
    selectedOption: String,
    onSelectionChange: (UiText.StringResource) -> Unit,
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
                    text = { (selectionOption.asString()) },
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
                painter = painterResource(id = R.drawable.rubble),
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

    Column(
        modifier = modifier
            .selectableGroup(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            RadioButton(
                selected = isSelected,
                onClick = {
                    onSelectionChange(true)
                },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Green
                )
            )
            Text(
                text = "Yes",
                color = if (isSelected) Color.Green else MaterialTheme.colorScheme.onSurface
            )


            RadioButton(
                selected = !isSelected,
                onClick = {
                    onSelectionChange(false)
                },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red
                )
            )
            Text(
                text = "No",
                color = if (!isSelected) Color.Red else MaterialTheme.colorScheme.onSurface
            )
        }

    }
}


@Composable
fun PaymentMethodItem(
    text: String,
    checked: ToggleableState,
    onCheckedChange: (ToggleableState) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        TriStateCheckbox(
            state = checked,
            onClick = { onCheckedChange(if (checked == ToggleableState.On) ToggleableState.Off else ToggleableState.On) },
            colors = CheckboxDefaults.colors(
                checkmarkColor = if (isSystemInDarkTheme()) authElements else Color.White,
                checkedColor = if (isSystemInDarkTheme()) Color.White else authElements,
                uncheckedColor = authElements,
            )
        )
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Profile(navigateTo = {})
}