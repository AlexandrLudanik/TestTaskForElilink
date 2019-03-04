package hiltonPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static hiltonPages.MainPageHilton.logger;

public class HotelPage {


    private WebDriver driver;

    public HotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@class='priceamount currencyCode-USD']")
    private List<WebElement> prices;

    public List<WebElement> allPrices() {
        return prices;
    }

    public RegisterPage chooseNumberWithMaxPrice(List<WebElement> prices) {
        String xpathMaxPrice = "(//*[@class='priceamount currencyCode-USD'])";
        String xpathForSelectButton = "/ancestor::div[@class='priceamount-wrapper']/following-sibling::div[@class='link-wrapper']";
        int index = 0;
        int maxPrice = 0;
        for (int i = 0; i < prices.size(); i++) {
            try {
                if (Integer.parseInt(prices.get(i).getText().substring(3)) > maxPrice) {
                    maxPrice = Integer.parseInt(prices.get(i).getText().substring(3));
                    index = i + 1;
                }
            } catch (Exception e) {
            }
        }
        driver.findElement(By.xpath(xpathMaxPrice + "[" + index + "]" + xpathForSelectButton)).click();
        logger.info("Number with max price was chosen");
        return new RegisterPage(driver);
    }
}
