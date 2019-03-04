import hiltonPages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import tutPages.*;

public class WebDriverSettings {

    static WebDriver driver;
    MainPageTutBy mainPageTutBy;
    MainPageHilton mainPageHilton;
    FindHotelPage findHotelPage;
    HotelPage hotelPage;
    RegisterPage registerPage;
    PaymentPage paymentPage;
    private BufferedReader reader;
    private String browserName;


    {
        try {
            reader = new BufferedReader(new FileReader("src\\main\\resources\\browser.txt"));
            browserName = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void setUp() {
        if (driver != null) {
            return;
        }
        driver = InitializationWebDriver.initialize(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook(
                new Thread(new Runnable() {
                    public void run() {
                        driver.quit();
                        driver = null;
                    }
                }));
    }
}
