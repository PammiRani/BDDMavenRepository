package hooks;

import com.google.common.primitives.Bytes;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Properties;

public class MyHooks {

    private WebDriver driver;
    Properties prop;

    @Before
    public void setup(){
        prop=ConfigReader.initializeProperties();
        driver=DriverFactory.initializeBrowser(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario){
        String scenarioName=scenario.getName().replace(" ","_");
        if(scenario.isFailed()){
            byte[] srcScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(srcScreenShot,"image/png",scenarioName);
        }
        driver.quit();
    }

}
