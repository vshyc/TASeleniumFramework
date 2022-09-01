package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/header/div/div/a")
    public WebElement tellMeMoreButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/section/div/div[2]/div[1]/div/ul/li[1]")
    public WebElement leaderTwitter;

    @FindBy(xpath = "//li[.//a[contains(@href, 'goc')]]")
    public WebElement leaderFacebook;

    @FindBy(xpath = "//li[.//a[@href='https://www.linkedin.com/in/aleksandra-szyca-733318198/']]")
    public WebElement leaderLinkedIn;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
