package com.example.defensedemo.screenshot

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.defensedemo.SettingsScreen
import com.example.defensedemo.ui.theme.DefenseDemoTheme
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class SettingsScreenTest {
    @get:Rule
    val roborazziRule = ScreenshotUtil.customRule

    @Test
    fun capture() {
        captureRoboImage {
            DefenseDemoTheme {
                SettingsScreen()
            }
        }
    }
}