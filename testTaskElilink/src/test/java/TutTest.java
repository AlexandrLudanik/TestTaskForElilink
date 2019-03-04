import tutPages.MainPageTutBy;

public class TutTest extends WebDriverSettings{

    @org.testng.annotations.Test
    public void checkLuka(){
        mainPageTutBy = new MainPageTutBy(driver);
        driver.get("https://www.tut.by/");
        mainPageTutBy.inputTextInSearchField("лукашенко");
        mainPageTutBy.clickSearchButton();

    }
}
