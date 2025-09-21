package pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVars;

//import static utils.*;
import java.time.Duration;

import static driverFactory.DriverFactory.getDriver;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(getDriver(), this);
    }
    public String getRandomText(int num){
        return RandomStringUtils.randomAlphabetic(num);
    }
    public String getRandomNumber(int num){
        return RandomStringUtils.randomNumeric(num);
    }
    public void navigateToUlr(String URL){
        getDriver().get(URL);
    }
    public void sendKeys(WebElement element, String input){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.webDriverWaitSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(input);
    }
    public void clickOnElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.webDriverWaitSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
