package io.github.mfaisalkhatri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    private WebElement registerYourAccountLink () {
        return this.driver.findElement (By.linkText ("Register your account"));
    }

    public RegistrationPage navigateToRegistrationPage () {
        registerYourAccountLink ().click ();
        return new RegistrationPage (driver);
    }

}
