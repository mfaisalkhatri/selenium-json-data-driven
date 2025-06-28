package io.github.mfaisalkhatri.test;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;

import io.github.mfaisalkhatri.data.RegistrationData;
import io.github.mfaisalkhatri.data.RegistrationDataBuilder;
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
        final RegistrationPage registrationPage = new RegistrationPage (this.driver);
        this.driver.get ("https://practicesoftwaretesting.com/auth/register");
        System.out.println ("Navigate to the url success!");

        assertEquals (registrationPage.pageHeader (), "Customer registration");
        System.out.println ("verified page header!");
        registrationPage.fillRegistrationForm (registrationData);

        assertEquals (registrationPage.passwordAlertMessage (),
            "The given password has appeared in a data leak. Please choose a different password.");
    }
}