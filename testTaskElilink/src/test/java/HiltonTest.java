import hiltonPages.*;

public class HiltonTest extends WebDriverSettings {

    @org.testng.annotations.Test
    public void check() {
        mainPageHilton = new MainPageHilton(driver);
        findHotelPage = new FindHotelPage(driver);
        hotelPage = new HotelPage(driver);
        registerPage = new RegisterPage(driver);
        paymentPage = new PaymentPage(driver);
        driver.get("http://www3.hilton.com");
        mainPageHilton.inputPlaceHotel("Washington, DC");
        mainPageHilton.clickOnAdvancedSearchLink();
        mainPageHilton.clickOnCheckInField();
        mainPageHilton.setData(mainPageHilton.allDate());
        mainPageHilton.chooseNumberOfGuests("2");
        mainPageHilton.ckickSearchButton();

        System.out.println(findHotelPage.getFreeHotelName());

        findHotelPage.clickSelectButton();
        hotelPage.chooseNumberWithMaxPrice(hotelPage.allPrices());

        registerPage.register("Alexandr", "Lukashenko", "375295555555", "lukashenkoIsGod@gmail.com", "Drozdy", "1234", "Minsk");
        registerPage.clickContinueButton();

        paymentPage.getTotalCost();
    }
}