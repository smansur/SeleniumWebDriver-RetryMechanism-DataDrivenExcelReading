package stepDefinition.Hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static driverFactory.DriverFactory.getDriver;
import static driverFactory.DriverFactory.quitDriver;

public class BaseHook {
    public static WebDriver driver;
    @BeforeAll
    public static void setUp(){
        driver = getDriver();
    }
    @AfterAll
    public static void tearDown(){
        quitDriver();
    }
    @AfterStep
    public void takeScreenShot(Scenario scenario){
        String fileName = String.valueOf(System.currentTimeMillis());
        if(scenario.isFailed()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", fileName+".png");
        }
    }
}
