package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if(webdriver.get()==null){
            webdriver.set(createDriver());
        }
        return webdriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver=null;
        String browser =System.getProperty("browserType");
        if(browser==null){
            try{
                File file = new File(System.getProperty("user.dir")+"/src/main/java/properties/config.properties");
                FileInputStream fis = new FileInputStream(file);
                Properties props = new Properties();
                props.load(fis);
                browser = props.getProperty("browser");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        switch (browser){
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
            }
            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                driver = new FirefoxDriver(options);
            }
        }
        return driver;
    }
    public static void quitDriver(){
        webdriver.get().quit();
        webdriver.remove();
    }
}
