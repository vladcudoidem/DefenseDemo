package com.example.defensedemo.screenshot

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.defensedemo.SettingItem
import com.example.defensedemo.ui.theme.DefenseDemoTheme
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(qualifiers = RobolectricDeviceQualifiers.Pixel7Pro)
class SettingsItemTest {
    @get:Rule
    val roborazziRule = ScreenshotUtil.customRule

    @Test
    fun capture() {
        captureRoboImage {
            DefenseDemoTheme {
                SettingItem(
                    title = "Wi-Fi",
                    description = "Manage the Wi-Fi connections."
                )
            }
        }
    }
}