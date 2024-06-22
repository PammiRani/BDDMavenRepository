package utils;

import io.opentelemetry.sdk.internal.JavaVersionSpecific;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {

    WebDriver driver;

    public ElementUtils(WebDriver driver){
        this.driver=driver;
    }

    public WebElement waitForElement(WebElement element,long durationInSec){
        WebElement webElement = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSec));
            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){
            e.printStackTrace();
        }

        return webElement;
    }

    public void clickOnElement(WebElement element,long durationInSec){
        WebElement webElement=waitForElement(element,durationInSec);
        webElement.click();
    }

    public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSec){
        WebElement webElement=waitForElement(element,durationInSec);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(textToBeTyped);
    }

    public void selectOptionInDropdown(WebElement element, String dropDownOption, long durationInSec){
        WebElement webElement=waitForElement(element,durationInSec);
        Select sc=new Select(webElement);
        sc.selectByVisibleText(dropDownOption);
    }

    public Alert waitForAlert(long durationInSec){
        Alert alert = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSec));
            alert = wait.until(ExpectedConditions.alertIsPresent());
        }catch (Exception e){
            e.printStackTrace();
        }

        return alert;
    }

    public void acceptAlert(long durationInSec){
        Alert alert=waitForAlert(durationInSec);
        alert.accept();
    }

    public void dismissAlert(long durationInSec){
        Alert alert=waitForAlert(durationInSec);
        alert.dismiss();
    }

    public WebElement waitForVisibilityOfElement(WebElement element, long durationInSec){
        WebElement webElement=null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSec));
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            e.printStackTrace();
        }

        return webElement;
    }

    public void mouseHoverAndClick(WebElement element, long durationInSec){
        WebElement webElement=waitForVisibilityOfElement(element, durationInSec);
        Actions act=new Actions(driver);
        act.moveToElement(webElement).click().build().perform();
    }

    public void javaScriptClick(WebElement element, long durationInSec){
        WebElement webElement=waitForVisibilityOfElement(element,durationInSec);
        JavascriptExecutor javascript=(JavascriptExecutor) driver;
        javascript.executeScript("arguments[0].click();",webElement);
    }

    public void javaScriptType(WebElement element, long durationInSec, String textToBeTyped){
        WebElement webElement=waitForVisibilityOfElement(element,durationInSec);
        JavascriptExecutor javascript=(JavascriptExecutor) driver;
        javascript.executeScript("arguments[0].value='"+textToBeTyped+"'",webElement);
    }





}
