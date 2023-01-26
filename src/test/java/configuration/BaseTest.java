package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testcontainers.utility.DockerImageName;
import properties.EnvConfig;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.time.Duration;

public class BaseTest {
    public static Wait<WebDriver> wait;
    public static WebDriver driver;
    public static EnvConfig envConfig = ConfigFactory.create(EnvConfig.class);


    @BeforeAll
    public static void baseSetUp(){
        if (System.getenv("docker").equalsIgnoreCase("true")) {
            dockerConfig();
        } else {
            mangerConfig();
        }
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

    private static void dockerConfig() {
        BrowserWebDriverContainer firefox = new BrowserWebDriverContainer(
                DockerImageName.parse("seleniarm/standalone-firefox")
                        .asCompatibleSubstituteFor("selenium/standalone-chrome"))
                .withCapabilities(new FirefoxOptions());
        firefox.start();
        driver = new RemoteWebDriver(firefox.getSeleniumAddress(), new FirefoxOptions());
    }

    private static void mangerConfig(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

}
