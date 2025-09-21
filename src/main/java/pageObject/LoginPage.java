package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ExcelUtilities;
import utils.GlobalVars;

import java.time.Duration;

import static driverFactory.DriverFactory.getDriver;

public class LoginPage extends BasePage{
    public LoginPage(){
        super();
    }
    private @FindBy(id="user-name") WebElement username;
    private @FindBy(id="password") WebElement password;
    private @FindBy(id="login-button") WebElement loginButton;
    private @FindBy(xpath="//div[@id='shopping_cart_container']") WebElement cartIcon;

    String fileName = System.getProperty("user.dir")+"/src/main/java/utils/excelData.xlsx";
    String sheetName = "Sheet1";
    public void navigateToLoginPage(){
        navigateToUlr(ExcelUtilities.readExcelData(fileName,sheetName,1,2));
    }
    public void setUsername(){
        sendKeys(username, ExcelUtilities.readExcelData(fileName,sheetName,1,0));
    }
    public void setPassword(){
        sendKeys(password,ExcelUtilities.readExcelData(fileName,sheetName,1,1));
    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
    public void validateHomePage(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.webDriverWaitSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
    }
    public void setInvalidPassword(){
        sendKeys(password,"test1234");
    }
}
