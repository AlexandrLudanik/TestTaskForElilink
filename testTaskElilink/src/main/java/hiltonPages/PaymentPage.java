package hiltonPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static hiltonPages.MainPageHilton.logger;

public class PaymentPage {




    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='total-dollars']")
    private WebElement totalCost;

    public void getTotalCost() {
        System.out.println(totalCost.getText());
        logger.info("Total cost is "+totalCost.getText());
    }
}
