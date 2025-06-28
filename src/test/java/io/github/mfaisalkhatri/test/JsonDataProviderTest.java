package io.github.mfaisalkhatri.test;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;

import io.github.mfaisalkhatri.data.RegistrationData;
import io.github.mfaisalkhatri.data.RegistrationDataBuilder;
import io.github.mfaisalkhatri.pages.HomePage;
import io.github.mfaisalkhatri.pages.LoginPage;
import io.github.mfaisalkhatri.pages.RegistrationPage;
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
    public void testRegistrationPasswordAlert (final RegistrationData registrationData) {
        this.driver.get ("https://practicesoftwaretesting.com/");

        HomePage homePage = new HomePage (driver);
        LoginPage loginPage = homePage.navigateToLoginPage ();
        RegistrationPage registrationPage = loginPage.navigateToRegistrationPage ();

        assertEquals (registrationPage.pageHeader (), "Customer registration");

        registrationPage.fillRegistrationForm (registrationData);
        assertEquals (registrationPage.passwordAlertMessage (),
            "The given password has appeared in a data leak. Please choose a different password.");
    }
}