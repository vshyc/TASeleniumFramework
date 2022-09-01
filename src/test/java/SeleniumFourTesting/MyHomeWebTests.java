package SeleniumFourTesting;

import configuration.BaseTest;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.emulation.Emulation;

import pages.HomePage;


import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class MyHomeWebTests extends BaseTest {

    private static HomePage homePage;



    @BeforeAll
    @Step("Set up")
    public static void setUp(){
        homePage = new HomePage(driver);
    }

    @Test
    public void mainPageTest(){
        driver.get(envConfig.baseUri());
        Assertions.assertThat(driver.getTitle()).isEqualTo("Dariusz Szyca's App");
    }

    @Test
    public void mainTellMeMoreButton() throws IOException {
        driver.get(envConfig.baseUri());
        takeScreenShotOfElement(homePage.tellMeMoreButton,"button");
        Assertions.assertThat(driver.getTitle()).isEqualTo("Dariusz Szyca's App");
    }

    @Test
    public void accountRegistrationPage(){
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(Optional.of(51.1642292),
                Optional.of(10.4541194),
                Optional.of(1)));
//        driver.manage().addCookie(new Cookie("X-Forwarded-For", "85.214.132.117"));
        driver.get("https://www.iplocation.net/");
//        Assertions.assertThat(driver.getTitle()).isEqualTo("Dariusz Szyca's App");
    }

    private void takeScreenShotOfElement(@NotNull TakesScreenshot element, String fileName) throws IOException {
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./"+fileName+".png"));
    }


}
