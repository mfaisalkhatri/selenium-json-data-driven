package io.github.mfaisalkhatri.test;

import java.time.Duration;

import io.github.mfaisalkhatri.utils.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest implements WebDriverProvider {

    protected  WebDriver driver;

    @Override
    public WebDriver getDriver () {
        return driver;
    }

    @BeforeClass
    public void setup () {
        ChromeOptions chromeOptions = new ChromeOptions ();
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.addArguments ("--headless=new", "--no-sandbox", "--window-size=1920,1080");

        this.driver = new ChromeDriver (chromeOptions);
        this.driver.manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (30));
    }

    @AfterClass
    public void tearDown () {
        if (driver != null) {
            this.driver.quit ();
        }
    }
}
