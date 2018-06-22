import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.BookingPage;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;


public class BookingTest {

    WebDriver driver;
    BookingPage bookingPage;
    String url = "http://hotel-test.equalexperts.io/";
    String firstname = "FirstName" + String.valueOf(System.currentTimeMillis()),
            lastname = "Surname",
            price = "123",
            deposit = "true",
            checkin = "2",
            checkout = "5";

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        bookingPage = new BookingPage(driver);
        driver.get(url);
        ((JavascriptExecutor) driver).executeScript("window.focus();");
        assertTrue(bookingPage.pageLoaded());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void bookHotel() {
        bookingPage.bookHotel(
                firstname,
                lastname,
                price,
                deposit,
                checkin,
                checkout
        );
        assertTrue(
                bookingPage.isBookingSuccessful(
                        firstname,
                        lastname,
                        price,
                        deposit
                ));
    }

    @Test(dependsOnMethods = "bookHotel")
    public void deleteBooking() {
        bookingPage
                .deleteBooking(firstname);

        assertFalse(bookingPage.isRecordDisplayed(firstname));
    }
}
