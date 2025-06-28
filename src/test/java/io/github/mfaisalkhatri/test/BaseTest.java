package io.github.mfaisalkhatri.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected  WebDriver driver;

    @BeforeClass
    public void setup () {
        ChromeOptions chromeOptions = new ChromeOptions ();
        chromeOptions.addArguments ("--headless=new");
        chromeOptions.addArguments ("disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");

        this.driver = new ChromeDriver (chromeOptions);
        this.driver.manage ()
            .window ()
            .maximize ();
        this.driver.manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (30));
    }

    @AfterClass
    public void tearDown () {
        this.driver.quit ();
    }
}
