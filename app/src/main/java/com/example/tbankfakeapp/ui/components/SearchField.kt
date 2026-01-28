package com.example.tbankfakeapp.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tbankfakeapp.R
import com.example.tbankfakeapp.ui.theme.AppColors

@Composable
fun SearchField(
    modifier: Modifier = Modifier
) {
    var textState by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        value = textState,
        onValueChange = { textState = it },
        singleLine = true,
        textStyle = TextStyle(color = Color.White, fontSize = 10.sp),
        cursorBrush = SolidColor(Color.White),
        modifier = modifier
            .fillMaxWidth()
            .height(37.dp)
    ) { innerTextField ->

        TextFieldDefaults.DecorationBox(
            value = textState,
            innerTextField = innerTextField,
            enabled = true,
            singleLine = true,
            visualTransformation = VisualTransformation.None,
            interactionSource = interactionSource,
            placeholder = { Text("Search", fontSize = 14.sp) },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_search_24),
                    contentDescription = null
                )
            },
            shape = RoundedCornerShape(19.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = AppColors.SearchBackground,
                unfocusedContainerColor = AppColors.SearchBackground,
                disabledContainerColor = AppColors.SearchBackground,

                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,

                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedPlaceholderColor = Color(0xFF9AA0A6),
                unfocusedPlaceholderColor = Color(0xFF9AA0A6),
                focusedLeadingIconColor = Color(0xFF9AA0A6),
                unfocusedLeadingIconColor = Color(0xFF9AA0A6),

                cursorColor = Color.White
            ),
            contentPadding = PaddingValues(
                start = 12.dp,
                end = 12.dp,
                top = 0.dp,
                bottom = 0.dp
            )
        )
    }
}