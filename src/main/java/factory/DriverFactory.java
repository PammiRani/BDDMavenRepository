package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.CommonUtils;

import java.time.Duration;
import java.util.EventListener;

public class DriverFactory {

    static WebDriver driver = null;

    public static WebDriver initializeBrowser(String browserName){

        if(browserName.equals("chrome")){
             driver=new ChromeDriver();
        } else if (browserName.equals("firefox")) {
             driver=new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));

        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }


}
