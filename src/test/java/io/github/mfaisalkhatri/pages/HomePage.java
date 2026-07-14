package io.github.mfaisalkhatri.pages;

import java.beans.Visibility;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver     driver;
    private final WebDriverWait wait;

    public HomePage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver, Duration.ofSeconds (30));
    }

    public LoginPage navigateToLoginPage () {
        signInLink ().click ();
        return new LoginPage (driver);
    }

    private WebElement signInLink () {
        return this.wait.until (ExpectedConditions.visibilityOfElementLocated (By.linkText ("Sign in")));
    }
}