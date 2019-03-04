import hiltonPages.RegisterPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class InitializationWebDriver {
    final static Logger logger = Logger.getLogger(InitializationWebDriver.class);

    private static WebDriver driver = null;

    public static WebDriver initialize(String name) {

        if (driver == null) {
            if (name.equalsIgnoreCase("Chrome")) {
                driver = new ChromeDriver();
                logger.info("Chrome browser is starting");
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            } else if (name.equalsIgnoreCase("Firefox")) {
                logger.info("Firefox browser is starting");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            } else if (name.equalsIgnoreCase("IE")) {
                logger.info("Internet Explorer browser is starting");
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            }
        }
        return driver;
    }
}
