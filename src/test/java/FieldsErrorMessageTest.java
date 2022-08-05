import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import page_object.MainPage;
import page_object.PersonalInfoPage;


@RunWith(Parameterized.class)
public class FieldsErrorMessageTest {

    private static WebDriver driver;
    private final By errorField;

    public FieldsErrorMessageTest(By errorField) {
        this.errorField = errorField;
    }

    @Parameterized.Parameters
    public static Object[][] getError() {
        PersonalInfoPage objError = new PersonalInfoPage(driver);
        return new Object[][] {
                {objError.getNameError()},
                {objError.getSurnameError()},
                {objError.getAddressError()},
                {objError.getMetroError()},
                {objError.getPhoneError()},
        };
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    //Тесты проверки сообщений об ошибках в полях ввода формы "Для кого самокат"
    @Test
    public void mainPageLogoTest() {
        PersonalInfoPage objPersonalInfoPage = new PersonalInfoPage(driver);
        objPersonalInfoPage.getScooterOrderPage();
        MainPage objMainPage = new MainPage(driver);
        objMainPage.cookieConfirm();
        objPersonalInfoPage.clickFurtherBotton();
        objPersonalInfoPage.isErrorDisplayed(errorField);
    }
}
