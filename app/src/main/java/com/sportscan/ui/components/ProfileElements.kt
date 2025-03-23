package com.sportscan.ui.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.ArrowDropUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sportscan.R
import com.sportscan.ui.theme.authElements
import com.sportscan.ui.theme.borderOutlinedTextField
import com.sportscan.ui.theme.darkYellow
import com.sportscan.ui.theme.errorColor
import com.sportscan.ui.theme.gradLogoDark
import com.sportscan.ui.theme.gradLogoLight
import com.sportscan.ui.theme.lightBlue
import com.sportscan.ui.theme.transparent

@Composable
fun LogoElements(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(18.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.app_name),
                fontSize = 24.sp,
                style = TextStyle(brush = if (isSystemInDarkTheme()) gradLogoDark else gradLogoLight)
            )
            SimpleText(
                text = stringResource(R.string.profile_logo_small_text),
            )
        }
        SimpleText(
            text = stringResource(R.string.contact_with_us),
            textColor = authTextColor(),
            modifier = Modifier.clickable { }
        )
    }
}

@Composable
fun SectionPhoto(
    modifier: Modifier = Modifier,
    uriList: List<Uri> = emptyList(),
    onImagesSelected: (List<Uri>) -> Unit
) {

    val multiplePhotoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(),
        onResult = onImagesSelected
    )

    Column(
        modifier = modifier.clip(MaterialTheme.shapes.small),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(uriList.size) { index ->
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(uriList[index])
                        .crossfade(true).build(),
                    contentDescription = stringResource(R.string.cont_desc_section_photo),
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                )
            }
        }
        Button(
            modifier = Modifier
                .height(50.dp)
                .border(
                    width = 2.dp,
                    color = lightBlue,
                    shape = MaterialTheme.shapes.extraLarge
                ),
            onClick = {
                multiplePhotoPicker.launch(
                    PickVisualMediaRequest(
                        ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                )
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = screenBackground(),
            )

        ) {
            SimpleText(
                text = stringResource(R.string.button_pick_images)
            )
        }
    }
}


@Composable
fun InputProfileField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    prefix: @Composable (() -> Unit)? = null,
    maxLetters: Int = 300
) {
    val focusManager = LocalFocusManager.current
    var isPlaying by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        value = value,
        onValueChange = { if (it.length <= maxLetters) onValueChange(it) },
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                isPlaying = !isPlaying
            }
        ),
        trailingIcon = {
            TrailingIconAnim(isPlaying = isPlaying)
        },
        textStyle = TextStyle(fontSize = 18.sp),
        placeholder = {
            SimpleText(
                text = placeholder,
                textSize = 12.sp,
                textColor = Color(0.5f, 0.5f, 0.5f, 0.8f)
            )
        },
        shape = MaterialTheme.shapes.extraLarge,
        prefix = prefix,
        colors = TextFieldDefaults.colors(
            focusedTextColor = focusedFieldContent(),
            unfocusedIndicatorColor = transparent,
            focusedIndicatorColor = borderOutlinedTextField,
            errorContainerColor = errorColor,
            errorTextColor = errorColor,
            errorIndicatorColor = errorColor,
            focusedTrailingIconColor = focusedFieldContent(),
            unfocusedTrailingIconColor = transparent,
            unfocusedContainerColor = authInputField(),
            focusedContainerColor = authInputField()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedField(
    modifier: Modifier = Modifier,
    options: List<String>,
    selectedOption: String,
    onSelectionChange: (String) -> Unit,
) {
    var isExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = true },
    ) {
        OutlinedTextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .menuAnchor(type = MenuAnchorType.PrimaryEditable, enabled = true),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 15.sp,
                textAlign = TextAlign.Start
            ),
            shape = MaterialTheme.shapes.extraLarge,
            colors = TextFieldDefaults.colors(
                focusedTextColor = focusedFieldContent(),
                unfocusedIndicatorColor = transparent,
                focusedIndicatorColor = borderOutlinedTextField,
                errorContainerColor = errorColor,
                errorTextColor = errorColor,
                errorIndicatorColor = errorColor,
                focusedTrailingIconColor = focusedFieldContent(),
                unfocusedTrailingIconColor = transparent,
                unfocusedContainerColor = authInputField(),
                focusedContainerColor = authInputField()
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
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    costPeriod: String,
    onCostPeriodChange: (String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
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
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_ruble),
                contentDescription = stringResource(R.string.cont_desc_rubble_price),
                tint = darkYellow
            )
        },
        suffix = {
            SimpleText(
                text = costPeriod,
            )
        },
        trailingIcon = {
            IconButton(onClick = { isExpanded = true }) {
                if (isExpanded) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowDropUp,
                        contentDescription = stringResource(
                            R.string.cont_desc_collapsed
                        ),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                } else {
                    Icon(
                        imageVector = Icons.Rounded.ArrowDropDown,
                        contentDescription = stringResource(
                            R.string.cont_desc_expanded
                        ),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        },
        shape = MaterialTheme.shapes.extraLarge,
        colors = TextFieldDefaults.colors(
            focusedTextColor = focusedFieldContent(),
            unfocusedIndicatorColor = transparent,
            focusedIndicatorColor = borderOutlinedTextField,
            errorContainerColor = errorColor,
            errorTextColor = errorColor,
            errorIndicatorColor = errorColor,
            focusedTrailingIconColor = focusedFieldContent(),
            unfocusedTrailingIconColor = transparent,
            unfocusedContainerColor = authInputField(),
            focusedContainerColor = authInputField()
        )
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
                onCostPeriodChange(context.getString(R.string.hour))
                isExpanded = false
            },
            text = { SimpleText(text = stringResource(R.string.hour)) }
        )
        HorizontalDivider()
        DropdownMenuItem(
            onClick = {
                onCostPeriodChange(context.getString(R.string.day))
                isExpanded = false
            },
            text = { SimpleText(text = stringResource(R.string.day)) }
        )
        HorizontalDivider()
        DropdownMenuItem(
            onClick = {
                onCostPeriodChange(context.getString(R.string.week))
                isExpanded = false
            },
            text = { SimpleText(text = stringResource(R.string.week)) }
        )
        HorizontalDivider()
        DropdownMenuItem(
            onClick = {
                onCostPeriodChange(context.getString(R.string.month))
                isExpanded = false
            },
            text = { SimpleText(text = stringResource(R.string.month)) }
        )
        HorizontalDivider()
        DropdownMenuItem(
            onClick = {
                onCostPeriodChange(context.getString(R.string.year))
                isExpanded = false
            },
            text = { SimpleText(text = stringResource(R.string.year)) }
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
        verticalArrangement = Arrangement.Center
    ) {
        SimpleText(
            text = text,
            modifier = Modifier.padding(start = 12.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            RadioButton(
                selected = isSelected,
                onClick = {
                    onSelectionChange(true)
                }
            )
            SimpleText(text = stringResource(R.string.yes))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            RadioButton(
                selected = !isSelected,
                onClick = {
                    onSelectionChange(false)
                }
            )
            SimpleText(text = stringResource(R.string.no))
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
                checkedColor = focusedFieldContent(),
                uncheckedColor = authElements,
            )
        )
        SimpleText(
            text = text,
        )
    }
}


@Composable
fun SocialMediaField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: @Composable () -> Unit
) {
    val focusManager = LocalFocusManager.current
    var isPlaying by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        value = value,
        onValueChange = { if (it.length <= 300) onValueChange(it) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Uri,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                isPlaying = !isPlaying
            }
        ),
        leadingIcon = {
            leadingIcon()
        },
        trailingIcon = {
            TrailingIconAnim(isPlaying = isPlaying)
        },
        textStyle = TextStyle(fontSize = 18.sp),
        placeholder = {
            SimpleText(
                text = placeholder,
                textSize = 16.sp,
                textColor = Color(0.5f, 0.5f, 0.5f, 0.8f)
            )
        },
        shape = MaterialTheme.shapes.extraLarge,
        colors = TextFieldDefaults.colors(
            focusedTextColor = focusedFieldContent(),
            unfocusedIndicatorColor = transparent,
            focusedIndicatorColor = borderOutlinedTextField,
            errorContainerColor = errorColor,
            errorTextColor = errorColor,
            errorIndicatorColor = errorColor,
            focusedTrailingIconColor = focusedFieldContent(),
            unfocusedTrailingIconColor = transparent,
            unfocusedContainerColor = authInputField(),
            focusedContainerColor = authInputField()
        )
    )
}

@Composable
fun PhoneField(
    modifier: Modifier = Modifier,
    phoneNumber: String,
    mask: String = "999 999 99 99",
    maskNumber: Char = '9',
    onPhoneNumberChanged: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    var isPlaying by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        value = phoneNumber,
        onValueChange = { it ->
            if (it.length <= 10) {
                onPhoneNumberChanged(it.take(mask.count { it == maskNumber }))
            }
        },
        placeholder = {
            SimpleText(
                text = stringResource(R.string.placeholder_cont_phone_number),
                textSize = 12.sp,
                textColor = Color(0.5f, 0.5f, 0.5f, 0.8f),
                textAlign = TextAlign.End
            )
        },
        prefix = { Text(text = "+7") },
        textStyle = TextStyle(fontSize = 18.sp),
        trailingIcon = {
            TrailingIconAnim(isPlaying = isPlaying)
        },
        shape = MaterialTheme.shapes.extraLarge,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                isPlaying = !isPlaying
            }
        ),
        visualTransformation = PhoneVisualTransformation(mask, maskNumber),
        colors = TextFieldDefaults.colors(
            focusedTextColor = focusedFieldContent(),
            unfocusedIndicatorColor = transparent,
            focusedIndicatorColor = borderOutlinedTextField,
            errorContainerColor = errorColor,
            errorTextColor = errorColor,
            errorIndicatorColor = errorColor,
            focusedTrailingIconColor = focusedFieldContent(),
            unfocusedTrailingIconColor = transparent,
            unfocusedContainerColor = authInputField(),
            focusedContainerColor = authInputField()
        )
    )
}

class PhoneVisualTransformation(val mask: String, val maskNumber: Char) : VisualTransformation {
    private val maxLength = mask.count { it == maskNumber }
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.length > maxLength) text.take(maxLength) else text
        val annotatedString = buildAnnotatedString {
            if (trimmed.isEmpty()) return@buildAnnotatedString

            var maskIndex = 0
            var textIndex = 0
            while (textIndex < trimmed.length && maskIndex < mask.length) {
                if (mask[maskIndex] != maskNumber) {
                    val nextDigitIndex = mask.indexOf(maskNumber, maskIndex)
                    append(mask.substring(maskIndex, nextDigitIndex))
                    maskIndex = nextDigitIndex
                }
                append(trimmed[textIndex++])
                maskIndex++
            }
        }
        return TransformedText(annotatedString, PhoneOffsetMapper(mask, maskNumber))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PhoneVisualTransformation) return false
        if (mask != other.mask) return false
        if (maskNumber != other.maskNumber) return false
        return true
    }

    override fun hashCode(): Int {
        return mask.hashCode()
    }
}

private class PhoneOffsetMapper(val mask: String, val maskNumber: Char) : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int {
        var noneDigitCount = 0
        var i = 0
        while (i < offset + noneDigitCount) {
            if (mask[i++] != maskNumber) noneDigitCount++
        }
        return offset + noneDigitCount
    }

    override fun transformedToOriginal(offset: Int): Int =
        offset - mask.take(offset).count { it != maskNumber }
}