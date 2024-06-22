package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

    WebDriver driver;
    ElementUtils elementUtils;

    public RegisterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        elementUtils=new ElementUtils(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstName;

    @FindBy(id = "input-lastname")
    private WebElement lastName;

    @FindBy(id="input-email")
    private WebElement emailId;

    @FindBy(id="input-telephone")
    private WebElement telephoneNumber;

    @FindBy(id="input-password")
    private WebElement password;

    @FindBy(id="input-confirm")
    private  WebElement confirmPassword;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement privacyPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@name='newsletter'and @value='1']")
    private  WebElement yesRadioButton;

    @FindBy(xpath = "//input[@name='newsletter'and @value='0']")
    private WebElement noRadioButton;

    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement duplicateWarningMsg;

    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement warningMsgOfPrivacyPolicy;

    @FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
    private WebElement errorMsgOfFirstName;

    @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
    private WebElement errorMsgOfLastName;

    @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
    private WebElement errorMsgOfEmailId;

    @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
    private WebElement errorMsgOfTelephoneNum;

    @FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
    private WebElement errorMsgOfPassword;
    public void enterFirstName(String firstNameText){
        elementUtils.typeTextIntoElement(firstName,firstNameText,20);
    }

    public void enterLastName(String lastNameText){
        elementUtils.typeTextIntoElement(lastName,lastNameText,20);
    }

    public void enterEmailID(String emailIdText){
        elementUtils.typeTextIntoElement(emailId,emailIdText,20);
    }

    public void enterTelephoneNumber(String telephoneNumberText){
        elementUtils.typeTextIntoElement(telephoneNumber,telephoneNumberText,20);
    }

    public void enterPassword(String passwordText){
        elementUtils.typeTextIntoElement(password,passwordText,20);
    }

    public void enterConfirmPassword(String confirmPasswordText){
        elementUtils.typeTextIntoElement(confirmPassword,confirmPasswordText,20);
    }

    public void clickOnPrivacyPolicy(){
        elementUtils.clickOnElement(privacyPolicy,20);
    }

    public AccountSuccessPage clickOnContinueButton(){
        elementUtils.clickOnElement(continueButton,20);
        return new AccountSuccessPage(driver);
    }

    public void clickOnYesRadioButton(){
        elementUtils.clickOnElement(yesRadioButton,20);
    }

    public void clickOnNoRadioButton(){
        elementUtils.clickOnElement(noRadioButton,20);
    }

    public String getDuplicateWarningMsg(){
        return duplicateWarningMsg.getText();
    }

    public String getWarningMsgOfPrivacyPolicy(){
        return warningMsgOfPrivacyPolicy.getText();
    }

    public String getErrorMsgOfFirstName(){
        return errorMsgOfFirstName.getText();
    }

    public String getErrorMsgOfLastName(){
        return errorMsgOfLastName.getText();
    }

    public String getErrorMsgOfEmailId(){
        return errorMsgOfEmailId.getText();
    }

    public String getErrorMsgOfTelephoneNum(){
        return errorMsgOfTelephoneNum.getText();
    }

    public String getErrorMsgOfPassword(){
        return errorMsgOfPassword.getText();
    }

}
