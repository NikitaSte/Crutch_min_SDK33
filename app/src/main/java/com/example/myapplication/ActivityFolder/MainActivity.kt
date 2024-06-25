package com.example.myapplication.ActivityFolder

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.R
import com.google.android.material.color.DynamicColors
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private val executor: ExecutorService = Executors.newFixedThreadPool(4)

    companion object {
        private const val REQUEST_PERMISSIONS = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DynamicColors.applyToActivitiesIfAvailable(application)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val buttonLayout: LinearLayout = findViewById(R.id.button_layout)
        buttonLayout.setOnClickListener {
            executor.execute {
                openFastInternetSettings()
            }
        }

        val networkLayout: LinearLayout = findViewById(R.id.network_layout)
        networkLayout.setOnClickListener {
            executor.execute {
                openNetworkSettings()
            }
        }

        val bluetoothLayout: LinearLayout = findViewById(R.id.bluetooth_layout)
        bluetoothLayout.setOnClickListener {
            executor.execute {
                openVolumeSettings()
            }
        }

        val nfcLayout: LinearLayout = findViewById(R.id.nfc_layout)
        nfcLayout.setOnClickListener {
            executor.execute {
                openNFCSettings()
            }
        }

        val devopLayout: LinearLayout = findViewById(R.id.DevOp_options)
        devopLayout.setOnClickListener {
            executor.execute {
                openDevopSettings()
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                executor.execute {
                    openSettings()
                }
                true
            }
            R.id.action_authors -> {
                executor.execute {
                    openAuthors()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun openSettings() {
        val intent = Intent(this, Sett::class.java)
        startActivity(intent)
    }

    private fun openAuthors() {
        val intent = Intent(this, AuthorsActivity::class.java)
        startActivity(intent)
    }

    private fun openFastInternetSettings() {
        val intent = Intent(android.provider.Settings.Panel.ACTION_INTERNET_CONNECTIVITY)
        startActivity(intent)
    }

    private fun openVolumeSettings() {
        val intent = Intent(android.provider.Settings.Panel.ACTION_VOLUME)
        startActivity(intent)
    }

    private fun openNFCSettings() {
        val intent = Intent(android.provider.Settings.Panel.ACTION_NFC)
        startActivity(intent)
    }

    private fun openNetworkSettings() {
        val intent = Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS)
        startActivity(intent)
    }

    private fun openDevopSettings() {
        val intent = Intent(android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        executor.shutdownNow()
    }

}