import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import page_object.Waitings;
import main_page_elements.PageElements;

import static org.junit.Assert.assertEquals;

public class OrderStatusErrorTest extends PageElements {

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
    public void mainPageLogoTest() {

        String number = "FGH^$67";

        driver.get(pageURL);
        Waitings waiting = new Waitings(driver);
        waiting.waitForScooterMainPageLoad();
        driver.findElement(cookieConfirmButton).click();
        driver.findElement(orderStatusButton).click();
        waiting.waitForOrderNumberFieldIsClickable();
        driver.findElement(orderNumberField).sendKeys(number);
        driver.findElement(goButton).click();
        assertEquals(pageURL + "track?t=" + number, driver.getCurrentUrl());
        Assert.assertTrue(driver.findElement(notFountImg).isDisplayed());
    }
}
