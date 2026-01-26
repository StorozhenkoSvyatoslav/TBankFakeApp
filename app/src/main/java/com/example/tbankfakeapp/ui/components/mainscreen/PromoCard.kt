package com.example.tbankfakeapp.ui.components.mainscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tbankfakeapp.ui.theme.TBankAppTheme

@Preview
@Composable
fun CardPreview() {
    TBankAppTheme {
        PromoCard(
            modifier = Modifier,
            paintId = com.example.tbankfakeapp.R.drawable.promo_card1
        )
    }
}

@Composable
fun PromoCard(
    modifier: Modifier = Modifier,
    paintId: Int,
) {
    val shape = RoundedCornerShape(18.dp)

    OutlinedCard(
        modifier = modifier.size(100.dp), // квадрат; поменяй под дизайн
        shape = shape,
        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.25f)),
//        colors = CardDefaults.outlinedCardColors(
//            containerColor = Color(0xFF2A2A2A) // фон, если по краям будет "пусто"
//        )
    ) {
        Image(
            painter = painterResource(paintId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape) // чтобы картинка не "лезла" за скругления
        )
    }
}