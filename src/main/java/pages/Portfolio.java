package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Portfolio {

    @FindBy(xpath = "//*[@id=\"portfolio\"]/div[1]/div[2]/div[1]/a/div")
    public WebElement cvLink;



    public Portfolio(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
