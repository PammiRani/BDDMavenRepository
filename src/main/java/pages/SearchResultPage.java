package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    WebDriver driver;

    public SearchResultPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[contains(@class,'product-layout')]//div[@class='caption']//a")
    private WebElement validHPProduct;

    @FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
    private WebElement messageText;
    public boolean displayStatusOfValidProduct(){
        return validHPProduct.isDisplayed();
    }

    public String getMessageText(){
        return messageText.getText();
    }
}
