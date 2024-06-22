package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class HomePage {

    WebDriver driver;
    ElementUtils elementUtils;

    public HomePage(WebDriver driver){
          this.driver=driver;
        PageFactory.initElements(driver,this);
        elementUtils =new ElementUtils(driver);
    }

    @FindBy (xpath = "//span[text()='My Account']")
    private WebElement myAccount;

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(name = "search")
    private WebElement searchBox;

    @FindBy(xpath = "//button[contains(@class,'btn-default')]")
    private WebElement searchButton;
    public void clickOnMyAccount(){
        elementUtils.clickOnElement(myAccount,20);
    }

    public LoginPage clickOnLogin(){
        elementUtils.clickOnElement(loginLink,20);
        return new LoginPage(driver);
    }

    public RegisterPage clickOnRegisterLink(){
        elementUtils.clickOnElement(registerLink,20);
        return new RegisterPage(driver);
    }

    public void searchOnInputBox(String searchName){
        elementUtils.typeTextIntoElement(searchBox,searchName,20);
    }
    public SearchResultPage clickOnSearchButton(){
        elementUtils.clickOnElement(searchButton,20);
        return new SearchResultPage(driver);
    }




}
