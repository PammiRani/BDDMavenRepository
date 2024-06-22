package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class LoginPage {

    WebDriver driver;
    ElementUtils elementUtils;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        elementUtils=new ElementUtils(driver);
    }

    @FindBy(id = "input-email")
    private WebElement emailId;

    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private  WebElement warningMsg;
    public void provideEmailID(String emailID){
        elementUtils.typeTextIntoElement(emailId,emailID,20);
    }

    public void providePassword(String passwordText){
        elementUtils.typeTextIntoElement(password,passwordText,20);
    }

    public AccountPage clickOnSubmitButton(){
        elementUtils.clickOnElement(submit,20);
        return new AccountPage(driver);
    }

    public String verifyWarningMsg(){
        return warningMsg.getText();
    }





}
