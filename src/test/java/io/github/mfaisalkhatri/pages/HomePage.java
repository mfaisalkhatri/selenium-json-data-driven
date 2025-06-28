package io.github.mfaisalkhatri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public LoginPage navigateToLoginPage() {
        signInLink ().click ();
        return new LoginPage (driver);

    }
    private WebElement signInLink() {
        return this.driver.findElement (By.linkText ("Sign in"));
    }


}
