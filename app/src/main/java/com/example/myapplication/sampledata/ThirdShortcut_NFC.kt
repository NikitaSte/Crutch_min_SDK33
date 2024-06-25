package com.example.myapplication.sampledata

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity

class ThirdShortcut_NFC : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openNFCSettings();
        finish();
    }
    private fun openNFCSettings() {
        val intent = Intent(Settings.Panel.ACTION_NFC)
        startActivity(intent)
    }
}
