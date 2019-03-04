package hiltonPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static hiltonPages.MainPageHilton.logger;

public class FindHotelPage {


    private WebDriver driver;

    public FindHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='callout calloutCash']/following-sibling::div[@class='hotelDescription']/h2//span")
    private WebElement freeHotel;

    @FindBy(xpath = "//*[@class='callout calloutCash']/div[@class='calloutBox ']")
    private WebElement selectButton;

    public String getFreeHotelName() {
        logger.info("Hotel name is: "+freeHotel.getText());
        return freeHotel.getText();
    }

    public HotelPage clickSelectButton() {
        selectButton.click();
        logger.info("Select button clicked");
        return new HotelPage(driver);
    }
}
