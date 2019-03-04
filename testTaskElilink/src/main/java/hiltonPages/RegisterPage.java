package hiltonPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static hiltonPages.MainPageHilton.logger;

public class RegisterPage {



    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='guestFirstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[@id='guestLastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//*[@id='guestPhone']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//*[@id='guestEmail']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='guestUSAddress1']")
    private WebElement addressField;

    @FindBy(xpath = "//*[@id='guestUSZip']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//*[@id='guestUSCity']")
    private WebElement cityField;

    @FindBy(xpath = "//*[@id='guestUSState']")
    private WebElement dropBoxState;

    @FindBy(xpath = "//*[text()='Alabama']")
    private WebElement alabamaState;

    @FindBy(xpath = "//a[@role='button']")
    private WebElement continueButton;


    public void register(String firstName, String lastName, String phone, String email, String address, String zipCode, String city) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        phoneNumberField.sendKeys(phone);
        emailField.sendKeys(email);
        addressField.sendKeys(address);
        zipCodeField.sendKeys(zipCode);
        cityField.sendKeys(city);
        dropBoxState.click();
        alabamaState.click();
        logger.info("Set data in register form");
    }

    public PaymentPage clickContinueButton() {
        continueButton.click();
        logger.info("We clicked on Select button");
        return new PaymentPage(driver);
    }
}
