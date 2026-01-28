package com.example.tbankfakeapp.ui.components.mainscreen

import android.widget.GridLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tbankfakeapp.R

@Composable
@Preview(showBackground = true)
fun MainScreenProfile() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(R.drawable.icon),
                contentDescription = null,
            )
            Spacer(Modifier.width(18.dp))
            Text(
                text = "Profile",
                fontSize = 24.sp
            )
            Spacer(Modifier.width(9.dp))
            Icon(
                painter = painterResource(R.drawable.round_arrow_forward_ios_24),
                contentDescription = null,
                Modifier.size(18.dp)
            )
        }
        Icon(
            painter = painterResource(R.drawable.icon),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}