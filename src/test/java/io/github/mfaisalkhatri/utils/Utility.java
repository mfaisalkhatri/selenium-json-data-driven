package io.github.mfaisalkhatri.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class Utility {

    public static void takeScreenShot (WebDriver driver) {
        String timestamp = new SimpleDateFormat ("yyyyMMdd_HHmmss_SSS").format (new Date ());

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs (OutputType.FILE);
        String filename = timestamp + ".png";
        try {
            Files.createDirectories (Paths.get ("screenshots"));
            Files.copy (screenshot.toPath (), Paths.get ("screenshots", filename));
        } catch (IOException e) {
            throw new RuntimeException (e);
        }

    }
}