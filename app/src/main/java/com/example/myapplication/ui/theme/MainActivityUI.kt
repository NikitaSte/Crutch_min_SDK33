package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.R
import kotlinx.coroutines.launch

@Composable
fun MainActivityUI(openSettings: () -> Unit, openAuthors: () -> Unit, openAirplaneModeSettings: () -> Unit,
                   openVolumeSettings: () -> Unit, openNFCSettings: () -> Unit, openNetworkSettings: () -> Unit,
                   openDevopSettings: () -> Unit) {

    val scope = rememberCoroutineScope()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.surface)) {

        TopAppBar(
            title = { Text("Crutch", color = MaterialTheme.colors.onSurface) },
            backgroundColor = MaterialTheme.colors.surface,
            elevation = 0.dp
        )

        SettingsItem(
            iconResId = R.drawable.baseline_wifi_24,
            text = stringResource(id = R.string.First_button_text),
            onClick = { scope.launch { openAirplaneModeSettings() } }
        )

        SettingsItem(
            iconResId = R.drawable.baseline_volume_up_24,
            text = stringResource(id = R.string.shortcut_function_2_long),
            onClick = { scope.launch { openVolumeSettings() } }
        )

        SettingsItem(
            iconResId = R.drawable.baseline_nfc_24,
            text = stringResource(id = R.string.shortcut_function_3_long),
            onClick = { scope.launch { openNFCSettings() } }
        )

        SettingsItem(
            iconResId = R.drawable.baseline_airplanemode_active_24,
            text = stringResource(id = R.string.shortcut_function_4_long),
            onClick = { scope.launch { openNetworkSettings() } }
        )

        SettingsItem(
            iconResId = R.drawable.baseline_data_object_24,
            text = stringResource(id = R.string.shortcut_function_5_long),
            onClick = { scope.launch { openDevopSettings() } }
        )
    }
}

@Composable
fun SettingsItem(iconResId: Int, text: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(24.dp)
                .padding(4.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, fontSize = 16.sp, color = MaterialTheme.colors.onBackground)
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityUIPreview() {
    MainActivityUI(
        openSettings = {},
        openAuthors = {},
        openAirplaneModeSettings = {},
        openVolumeSettings = {},
        openNFCSettings = {},
        openNetworkSettings = {},
        openDevopSettings = {}
    )
}
