package com.example.defensedemo.screenshot

import com.dropbox.differ.SimpleImageComparator
import com.github.takahirom.roborazzi.RoborazziOptions
import com.github.takahirom.roborazzi.RoborazziRule
import com.github.takahirom.roborazzi.ThresholdValidator

object ScreenshotUtil {

    private val customImageComparator = SimpleImageComparator(
        maxDistance = 0.01f,
        hShift = 1,
        vShift = 1
    )
    private val customThresholdValidator = ThresholdValidator(0.002F)
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