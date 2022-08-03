import io.github.bonigarcia.wdm.WebDriverManager;
import main_page_elements.PageElements;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page_object.Waitings;

import static org.junit.Assert.assertEquals;

public class UrlTest extends PageElements{

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

    //Проверка перехода на главную станицу "Самоката" после нажатия на логотип "Самоката"
    @Test
    public void mainPageLogoTest() {
        driver.get(pageURL + "order");
        driver.findElement(cookieConfirmButton).click();
        driver.findElement(scooterLogo).click();
        assertEquals(pageURL, driver.getCurrentUrl());
    }

    //Проверка открытия новой вкладки с главной станицей Яндекса после нажатия на логотип Яндекса
    //На Firefox данный тест проходится быстрее, чем Chrome
    @Test
    public void yandexLogoTest() {
        driver.get(pageURL);
        driver.findElement(cookieConfirmButton).click();
        driver.findElement(yandexLogo).click();
        for (String tab: driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        Waitings waiting = new Waitings(driver);
        waiting.waitForMainYandexPage();
        assertEquals(yandexURL, driver.getCurrentUrl());
    }
}
