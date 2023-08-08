package net.learning.translator_kmm.android.translate.presentaion.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import net.learning.translator_kmm.android.core.theme.LightBlue
import net.learning.translator_kmm.core.presentation.UiLanguage
import net.learning.translator_kmm.presentation.UiHistoryItem

@Composable
fun TranslateItemHistory(
    item: UiHistoryItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(20.dp)
            )
            .gradientSurface()
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {

        ItemHistoryTextWithIcon(
            item.fromLanguage,
            item.fromText,
            LightBlue,
            MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        ItemHistoryTextWithIcon(
            item.toLanguage,
            item.toText,
            MaterialTheme.colorScheme.onSurface,
            MaterialTheme.typography.bodyLarge
        )

    }

}

@Composable
private fun ItemHistoryTextWithIcon(
    uiLanguage: UiLanguage,
    text: String,
    textColor: Color,
    textStyle: TextStyle
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        SmallLanguageIcon(uiLanguage)

        Spacer(modifier = Modifier.size(16.dp))

        Text(
            text = text,
            color = textColor,
            style = textStyle
        )

    }
}