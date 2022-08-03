import io.github.bonigarcia.wdm.WebDriverManager;
import main_page_elements.PageElements;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@RunWith(Parameterized.class)
public class FieldsErrorMessageTest extends PageElements{

    WebDriver driver;

    private final By errorField;

    public FieldsErrorMessageTest(By errorField) {
        this.errorField = errorField;
    }

    @Parameterized.Parameters
    public static Object[][] getError() {
        return new Object[][] {
                {nameErrorField},
                {surnameErrorField},
                {addressErrorField},
                {metroErrorField},
                {phoneErrorField},
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
        driver.get(pageURL + "order");
        driver.findElement(cookieConfirmButton).click();
        driver.findElement(furtherButton).click();
        Assert.assertTrue(driver.findElement(errorField).isDisplayed());
    }
}
