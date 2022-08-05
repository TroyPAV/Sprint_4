import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import page_object.NewWindows;
import page_object.MainPage;
import page_object.PersonalInfoPage;

public class UrlTest {

    private WebDriver driver;
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
        PersonalInfoPage objPersonalInfoPage = new PersonalInfoPage(driver);
        objPersonalInfoPage.getScooterOrderPage();
        MainPage objMainPage = new MainPage(driver);
        objMainPage.cookieConfirm();
        objMainPage.clickScooterLogo();
        objMainPage.isMainPageDisplayed();
    }

    //Проверка открытия новой вкладки с главной станицей Яндекса после нажатия на логотип Яндекса
    //На Firefox данный тест проходится быстрее, чем Chrome
    @Test
    public void yandexLogoTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.getScooterMainPage();
        objMainPage.waitForScooterMainPageLoad();
        objMainPage.cookieConfirm();
        objMainPage.clickYandexLogo();
        NewWindows objNewWindows = new NewWindows(driver);
        objNewWindows.newTab();
        objNewWindows.isYandexPageDisplayed();
    }
}
