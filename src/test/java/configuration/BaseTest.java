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
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;
import org.testcontainers.DockerClientFactory;
import org.testcontainers.containers.BrowserWebDriverContainer;
import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public static Wait<WebDriver> wait;
    public static WebDriver driver;
    public static String remote_url_firefox = "http://localhost:4444";
    public static EnvConfig envConfig = ConfigFactory.create(EnvConfig.class);
    private static BrowserWebDriverContainer firefox;

    @BeforeAll
    public static void baseSetUp() throws MalformedURLException {
        firefox = new BrowserWebDriverContainer()
                .withRecordingMode(RECORD_ALL, new File("target"))
                .withCapabilities(new FirefoxOptions());
        firefox.start();
        driver = firefox.getWebDriver();
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
