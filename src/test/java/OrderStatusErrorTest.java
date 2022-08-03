import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import page_object.MainPage;

public class OrderStatusErrorTest {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    //Проверка перехода на страницу статуса заказа с надписью "такого заказа нет",
    //при вводе несуществующего номера заказа
    @Test
    public void orderStatusErrorTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForScooterMainPageLoad();
        objMainPage.cookieConfirm();
        objMainPage.clickOrderStatusButton();
        objMainPage.waitForOrderNumberFieldIsClickable();
        objMainPage.setOrderNumber("FGH^$67");
        objMainPage.clickGoButton();
        objMainPage.isDisplayedErrorImg();
    }
}
