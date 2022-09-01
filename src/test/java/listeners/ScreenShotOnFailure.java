package listeners;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

public class ScreenShotOnFailure implements AfterEachCallback{

    private WebDriver driver;

    public ScreenShotOnFailure(WebDriver driver){
        this.driver = driver;
    }

    public void captureScreenShot(String fileName) throws IOException {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                fileName += UUID.randomUUID().toString();
                File targetFile = new File("./Screenshots/" + fileName + ".png");
                FileUtils.copyFile(scrFile, targetFile);
            }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        try {
            extensionContext.getElement();
        } catch (Throwable t) {
            captureScreenShot(extensionContext.getElement().toString());
            throw t;
        }
    }
}