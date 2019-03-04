package hiltonPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class MainPageHilton {
    final static Logger logger = Logger.getLogger(MainPageHilton.class);

    private WebDriver driver;

    public MainPageHilton(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='ADVANCED SEARCH']")
    private WebElement advancedSearchLink;

    @FindBy(xpath = "//*[@id='hotelSearchOneBox']")
    private WebElement hotelSearchField;

    @FindBy(xpath = "//*[@id='checkin']")
    private WebElement checkInField;

    @FindBy(xpath = "//*[@id='checkout']")
    private WebElement checkOutField;

    @FindBy(xpath = "//td[@role='gridcell']")
    private List<WebElement> dateList;

    @FindBy(xpath = "//*[@id=\"room1Adults\"]")
    private WebElement dropListNumberOfGuests;

    @FindBy(xpath = "//*[text()=' Go']")
    private WebElement searchButton;


    public void clickOnAdvancedSearchLink() {
        advancedSearchLink.click();
        logger.info("We clicked on Advanced Search link");
    }

    public void inputPlaceHotel(String place) {
        hotelSearchField.sendKeys(place);
        logger.info("Input Hotel "+place);
    }

    public void clickOnCheckInField() {
        checkInField.click();
        logger.info("We clicked on CheckIn");
    }

    public List<WebElement> allDate() {
        return dateList;
    }

    public void setData(List<WebElement> dateList) {
        int dateIndex;
        for (int i = 0; i < dateList.size(); i++) {
            if (dateList.get(i).getAttribute("aria-selected").equalsIgnoreCase("true")) {
                dateIndex = i + 1;
                dateList.get(dateIndex).click();
                checkOutField.click();
                dateList.get(dateIndex + 7).click();
            }
        }
        logger.info("We choose one week from tomorrow");
    }

    public void chooseNumberOfGuests(String numberOfGuests) {
        String optionXpath = String.format("//*[@id='room1Adults']/option[text()='%s']", numberOfGuests);
        dropListNumberOfGuests.click();
        driver.findElement(By.xpath(optionXpath)).click();
        logger.info("We choose number of guests");
    }

    public FindHotelPage ckickSearchButton() {
        searchButton.click();
        logger.info("We clicked on button Search");
        return new FindHotelPage(driver);
    }
}
