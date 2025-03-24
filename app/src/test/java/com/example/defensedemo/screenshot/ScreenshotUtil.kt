package com.example.defensedemo.screenshot

import com.dropbox.differ.SimpleImageComparator
import com.github.takahirom.roborazzi.RoborazziOptions
import com.github.takahirom.roborazzi.RoborazziRule
import com.github.takahirom.roborazzi.ThresholdValidator

object ScreenshotUtil {

    private val customImageComparator = SimpleImageComparator(
        maxDistance = 0.001f,
        hShift = 0,
        vShift = 0
    )
    private val customThresholdValidator = ThresholdValidator(0.0002F)
    val customRule = RoborazziRule(
        RoborazziRule.Options(
            outputDirectoryPath = "roborazzi/references",
            roborazziOptions = RoborazziOptions(
                compareOptions = RoborazziOptions.CompareOptions(
                    imageComparator = customImageComparator,
                    resultValidator = customThresholdValidator
                )
            )
        )
    )
}