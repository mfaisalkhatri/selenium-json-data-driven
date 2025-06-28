package io.github.mfaisalkhatri.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure (final ITestResult result) {
        Object testClass = result.getInstance ();
        WebDriver driver = ((WebDriverProvider) testClass).getDriver ();

        if (driver != null) {
            String testName = result.getMethod ()
                .getMethodName ();
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs (OutputType.FILE);
            try {
                Files.createDirectories (Paths.get ("screenshots"));
                Files.copy (screenshot.toPath (), Paths.get ("screenshots", testName+ ".png"));
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }
    }
}
