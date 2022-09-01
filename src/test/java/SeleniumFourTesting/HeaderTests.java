package SeleniumFourTesting;

import configuration.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.Header;

public class HeaderTests extends BaseTest {

    private static Header header;

    @BeforeAll
    public static void setUp(){
        header = new Header(driver);
        driver.get(envConfig.baseUri());
    }

    @Test
    public void portfolioHeaderLinkTest(){
        header.headerPortfolio.click();
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(envConfig.baseUri()+"portfolio");
    }
    @Test
    public void aboutHeaderLinkTest(){
        header.headerAbout.click();
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(envConfig.baseUri()+"about");
    }
    @Test
    public void contactHeaderLinkTest(){
        header.headerContact.click();
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(envConfig.baseUri()+"contact");
    }

    @Test
    public void loginHeaderLinkTest(){
        header.headerLogin.click();
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(envConfig.baseUri()+"login");
    }

    @Test
    public void registrationHeaderLinkTest(){
        header.headerRegistration.click();
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(envConfig.baseUri()+"registration");
    }
}
