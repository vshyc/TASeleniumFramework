package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import properties.EnvConfig;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public static Wait<WebDriver> wait;
    public static WebDriver driver;
    public static String remote_url_firefox = "http://localhost:4444";
    public static EnvConfig envConfig = ConfigFactory.create(EnvConfig.class);

    @BeforeAll
    public static void baseSetUp() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        options.setBrowserVersion("109.0");
        options.setPlatformName("LINUX");
        driver = new RemoteWebDriver(new URL(remote_url_firefox), options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Time out as the condition is not met")
                .ignoring(NoSuchElementException.class);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}