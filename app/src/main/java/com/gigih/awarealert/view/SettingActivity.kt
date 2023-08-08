package com.gigih.awarealert.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.gigih.awarealert.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("SharedPrefs", AppCompatActivity.MODE_PRIVATE)
        val isDarkMode = sharedPreferences?.getBoolean("DarkModeState", false)

        binding.msDarkmode.isChecked = isDarkMode ?: false
        binding.msDarkmode.setOnCheckedChangeListener { _, isChecked ->
            val editor = sharedPreferences?.edit()
            if (isChecked) {
                editor?.putBoolean("DarkModeState", true)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                editor?.putBoolean("DarkModeState", false)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            editor?.apply()
        }
    }
}