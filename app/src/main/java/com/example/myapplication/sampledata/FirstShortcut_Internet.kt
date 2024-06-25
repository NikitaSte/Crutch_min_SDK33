package com.example.myapplication.sampledata

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity


class FirstShortcut_Internet : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openAirplaneModeSettings();
        finish();
    }
    private fun openAirplaneModeSettings() {
        val intent = Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY)
        startActivity(intent)
    }
}

