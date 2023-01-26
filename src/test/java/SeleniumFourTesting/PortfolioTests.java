package SeleniumFourTesting;

import configuration.BaseTest;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.Header;
import pages.Portfolio;

public class PortfolioTests extends BaseTest {
    private static Portfolio portfolio;
    private static Header header;



    @BeforeAll
    @Step("Set up")
    public static void setUp(){
        portfolio = new Portfolio(driver);
        header = new Header(driver);
        driver.get(envConfig.baseUri());
    }

    @Test
    public void portfolioCvTest(){
        header.headerPortfolio.click();
        portfolio.cvLink.click();
        Assertions.assertThat(driver.getCurrentUrl()).isEqualToIgnoringCase(envConfig.baseUri()+"cv");
    }


}
