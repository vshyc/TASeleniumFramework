package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    @FindBy(id = "headerHome")
    public WebElement headerHome;

    @FindBy(id = "headerPortfolio")
    public WebElement headerPortfolio;

    @FindBy(id = "headerAbout")
    public WebElement headerAbout;

    @FindBy(id = "headerContact")
    public WebElement headerContact;

    @FindBy(id = "headerLogin")
    public WebElement headerLogin;

    @FindBy(id = "headerRegistration")
    public WebElement headerRegistration;

    public Header(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
