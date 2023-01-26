package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://home.szycad.com.pl/portfolio
public class HomeSzycadComPlPortfolioPage {
    // No page elements added

    public HomeSzycadComPlPortfolioPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}