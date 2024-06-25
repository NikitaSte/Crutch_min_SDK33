package com.example.myapplication.sampledata

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity

class FourthShortcut_Network : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       openNetworkSettings();
        finish();
    }
    private fun openNetworkSettings() {
        val intent = Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS)
        startActivity(intent)
    }
}