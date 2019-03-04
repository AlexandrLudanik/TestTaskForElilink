package tutPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageTutBy {

    private WebDriver driver;

    public MainPageTutBy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='search_from_str']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@name='search']")
    private WebElement searchButton;

    public void inputTextInSearchField(String text) {
        searchField.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
