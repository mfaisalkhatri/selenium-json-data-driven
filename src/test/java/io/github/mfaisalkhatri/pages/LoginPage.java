package io.github.mfaisalkhatri.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private       WebDriver     driver;
    private final WebDriverWait wait;

    public LoginPage (WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait (driver, Duration.ofSeconds (30));
    }

    private WebElement registerYourAccountLink () {
        return this.wait.until (ExpectedConditions.visibilityOfElementLocated (By.linkText ("Register your account")));
    }

    public RegistrationPage navigateToRegistrationPage () {
        registerYourAccountLink ().click ();
        return new RegistrationPage (driver);
    }
}