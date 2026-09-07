package io.github.mfaisalkhatri.test;

import static io.github.mfaisalkhatri.utils.Utility.takeScreenShot;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import io.github.mfaisalkhatri.data.RegistrationData;
import io.github.mfaisalkhatri.data.RegistrationDataBuilder;
import io.github.mfaisalkhatri.pages.HomePage;
import io.github.mfaisalkhatri.pages.LoginPage;
import io.github.mfaisalkhatri.pages.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JsonDataProviderTest extends BaseTest {

    @DataProvider
    public Iterator<RegistrationData> getValidRegistrationData () {
        final RegistrationDataBuilder registrationDataBuilder = new RegistrationDataBuilder ();
        return registrationDataBuilder.registrationData (true)
            .iterator ();
    }

    @Test (dataProvider = "getValidRegistrationData")
    public void testRegisterUser (final RegistrationData registrationData) {
        this.driver.get ("http://localhost:4200/");

        // this.driver.get ("https://practicesoftwaretesting.com/auth/register");
        takeScreenShot (driver);

        HomePage homePage = new HomePage (driver);
        //homePage.checkPlierProduct ();
        takeScreenShot (driver);
        LoginPage loginPage = homePage.navigateToLoginPage ();
        RegistrationPage registrationPage = loginPage.navigateToRegistrationPage ();

        assertEquals (registrationPage.pageHeader (), "Customer registration");

        registrationPage.fillRegistrationForm (registrationData);
                assertEquals (registrationPage.passwordAlertMessage (),
                    "The given password has appeared in a data leak. Please choose a different password.");

        //assertEquals (loginPage.pageHeading (), "Login");

    }
}