import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page_object.NewWindows;
import page_object.MainPage;

public class UrlTest {

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
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.cookieConfirm();
        objMainPage.clickScooterLogo();
        objMainPage.isMainPageDisplayed("https://qa-scooter.praktikum-services.ru/");
    }

    //Проверка открытия новой вкладки с главной станицей Яндекса после нажатия на логотип Яндекса
    //На Firefox данный тест проходится быстрее, чем Chrome
    @Test
    public void yandexLogoTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForScooterMainPageLoad();
        objMainPage.cookieConfirm();
        objMainPage.clickYandexLogo();
        NewWindows objNewWindows = new NewWindows(driver);
        objNewWindows.newTab();
        objNewWindows.isYandexPageDisplayed();
    }
}
