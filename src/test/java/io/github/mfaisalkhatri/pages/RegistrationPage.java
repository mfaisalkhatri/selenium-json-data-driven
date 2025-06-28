package io.github.mfaisalkhatri.pages;

import java.time.Duration;

import io.github.mfaisalkhatri.data.RegistrationData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private final WebDriver driver;
    private final WebDriverWait wait;


    public RegistrationPage (final WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait (driver, Duration.ofSeconds (30));
    }

    public void fillRegistrationForm (final RegistrationData registrationData) {
        firstNameField ().clear ();
        firstNameField ().sendKeys (registrationData.getFirstName ());
        lastNameField ().clear ();
        lastNameField ().sendKeys (registrationData.getLastName ());
        dobField ().sendKeys (registrationData.getDob ());
        streetField ().clear ();
        streetField ().sendKeys (registrationData.getStreet ());
        postalCodeField ().clear ();
        postalCodeField ().sendKeys (registrationData.getPostalCode ());
        cityField ().clear ();
        cityField ().sendKeys (registrationData.getCity ());
        stateField ().clear ();
        stateField ().sendKeys (registrationData.getState ());
        selectCountryVisibleText (registrationData.getCountry ());
        phoneField ().clear ();
        phoneField ().sendKeys (registrationData.getPhone ());
        emailAddressField ().clear ();
        emailAddressField ().sendKeys (registrationData.getEmailAddress ());
        passwordField ().clear ();
        passwordField ().sendKeys (registrationData.getPassword ());
        registerButton ().click ();
    }

    public String pageHeader () {
        return wait.until (ExpectedConditions.visibilityOfElementLocated (By.cssSelector ("app-register h3")))
            .getText ();
    }

    public String passwordAlertMessage () {
        return wait.until (ExpectedConditions.visibilityOfElementLocated (By.cssSelector (".alert-danger div")))
            .getText ();
    }

    private WebElement cityField () {
        return this.driver.findElement (By.id ("city"));
    }

    private WebElement countryField () {
        return this.driver.findElement (By.id ("country"));
    }

    private WebElement dobField () {
        return this.driver.findElement (By.id ("dob"));
    }

    private WebElement emailAddressField () {
        return this.driver.findElement (By.id ("email"));
    }

    private WebElement firstNameField () {
        return this.driver.findElement (By.id ("first_name"));
    }

    private WebElement lastNameField () {
        return this.driver.findElement (By.id ("last_name"));
    }

    private WebElement passwordField () {
        return this.driver.findElement (By.id ("password"));
    }

    private WebElement phoneField () {
        return this.driver.findElement (By.id ("phone"));
    }

    private WebElement postalCodeField () {
        return this.driver.findElement (By.id ("postal_code"));
    }

    private WebElement registerButton () {
        return this.driver.findElement (By.cssSelector (".btnSubmit"));
    }

    private void selectCountryVisibleText (final String countryName) {
        new Select (countryField ()).selectByVisibleText (countryName);
    }

    private WebElement stateField () {
        return this.driver.findElement (By.id ("state"));
    }

    private WebElement streetField () {
        return this.driver.findElement (By.id ("street"));
    }
}
