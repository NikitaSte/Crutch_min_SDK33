package com.example.myapplication.sampledata

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity


class SecondShortcut_Volume : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openVolumeSettings();
        finish();
    }
    private fun openVolumeSettings(){
        val intent = Intent(Settings.Panel.ACTION_VOLUME)
        startActivity(intent)
    }
}
