package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import properties.EnvConfig;

import java.time.Duration;

public class BaseTest {
    public static Wait<WebDriver> wait;
    public static ChromiumDriver driver;
    public static EnvConfig envConfig = ConfigFactory.create(EnvConfig.class);

    @BeforeAll
    public static void baseSetUp(){
        WebDriverManager.chromiumdriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Time out as the condition is not met")
                .ignoring(NoSuchElementException.class);
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
