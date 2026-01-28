package com.example.tbankfakeapp.ui.components.mainscreen

import android.R
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tbankfakeapp.ui.theme.AppColors
import com.example.tbankfakeapp.ui.theme.TBankAppTheme
import java.nio.file.WatchEvent

@Preview
@Composable
fun CardPreview() {
    TBankAppTheme {
        PromoCard(
            paintId = com.example.tbankfakeapp.R.drawable.promo_card6,
            title = "Title",
            isSeen = false,
            modifier = Modifier
        )
    }
}

@Composable
fun PromoCard(
    paintId: Int,
    title: String,
    isSeen: Boolean,
    modifier: Modifier = Modifier,
) {
    var isSeen by remember {mutableStateOf(isSeen)}

    val shape = RoundedCornerShape(18.dp)

    val cardSize = 94.dp
    val innerBorderWidth = 1.2.dp
    val gapToBlue = 1.6.dp
    val blueBorderWidth = 1.6.dp

    val context = LocalContext.current

    Box(
        modifier = modifier
            .border(
                width = blueBorderWidth,
                color = if (!isSeen) AppColors.PrimaryBlue else Color.Transparent,
                shape = RoundedCornerShape(22.dp)
            )
            .padding(gapToBlue)
            .size(100.dp)
    ) {
        OutlinedCard(
            modifier = Modifier.size(cardSize).align(Alignment.Center),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            shape = shape,
            border = BorderStroke(innerBorderWidth, Color.White.copy(alpha = 0.25f)),
            onClick = {
                isSeen = true
                Toast.makeText(context, "Открыли промо: ${title}", Toast.LENGTH_SHORT).show()
            }
        ) {
            Box(Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(paintId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Text(
                    text = title,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(8.dp)
                        .fillMaxWidth(),
                    fontSize = 12.sp,
                    lineHeight = 10.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}


@Composable
fun PromoCardRow(
    modifier: Modifier,
) {
    LazyRow(
        contentPadding = PaddingValues(start = 0.dp, end = 0.dp),
        horizontalArrangement = Arrangement.spacedBy(8.2.dp)
    ) {
        item{
            PromoCard(
                paintId = com.example.tbankfakeapp.R.drawable.promo_card6,
                title = "",
                isSeen = false,
                modifier = modifier,
            )
        }
        item{
            PromoCard(
                paintId = com.example.tbankfakeapp.R.drawable.promo_card2,
                title = "Спермааааааааа",
                isSeen = false,
                modifier = modifier,
            )
        }
        item{
            PromoCard(
                paintId = com.example.tbankfakeapp.R.drawable.promo_card4,
                title = "",
                isSeen = false,
                modifier = modifier,
            )
        }
        item{
            PromoCard(
                paintId = com.example.tbankfakeapp.R.drawable.promo_card1,
                title = "",
                isSeen = false,
                modifier = modifier,
            )
        }
        item{
            PromoCard(
                paintId = com.example.tbankfakeapp.R.drawable.promo_card5,
                title = "Целлюлит",
                isSeen = false,
                modifier = modifier,
            )
        }
    }
}