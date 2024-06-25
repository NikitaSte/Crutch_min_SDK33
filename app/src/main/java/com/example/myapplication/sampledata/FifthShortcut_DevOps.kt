package com.example.myapplication.sampledata

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity

class FifthShortcut_DevOps: ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openDevopSettings()
        finish();
    }
    private fun openDevopSettings() {
        val intent = Intent(android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
        startActivity(intent)
    }
}
