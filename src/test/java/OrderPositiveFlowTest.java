import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import main_page_elements.PageElements;
import page_object.FillingOrderFormAboutRent;
import page_object.FillingOrderFormPersonalInfo;
import page_object.Waitings;

@RunWith(Parameterized.class)
public class OrderPositiveFlowTest extends PageElements{

    WebDriver driver;

    private final By button;
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String rentalPeriod;
    private final String comment;

    public OrderPositiveFlowTest(By button, String name, String surname, String address, String metro, String phoneNumber, String deliveryDate, String rentalPeriod, String comment) {
        this.button = button;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getInfoForFillingOrder() {
        return new Object[][] {
                {topOrderButton,"Иван", "Иванов", "ул.Ивановская 12", "Сокольники", "+79213456789", "10.10.2022", "сутки", "Комментарий 1"},
                {bottomOrderButton,"Иван", "Иванов", "ул.Ивановская 12", "Сокольники", "+79213456789", "10.10.2022", "сутки", "Комментарий 1"},
                {topOrderButton,"Афанасий", "Петров", "ул.Стародеревенская 21", "Чистые пруды", "89219876543", "31.12.2022", "двое суток", "Комментарий 21"},
                {bottomOrderButton,"Афанасий", "Петров", "ул.Стародеревенская 21", "Чистые пруды", "89219876543", "31.12.2022", "двое суток", "Комментарий 21"},
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

    //Тесты проверки позитивного сценария заказа самоката, используя ВЕРХНЮЮ и НИЖНЮЮ кнопки "Заказать"
    //и два набора валидных тестовых данных
    @Test
    public void OrderTest() {
        driver.get(pageURL);
        Waitings waiting = new Waitings(driver);
        waiting.waitForScooterMainPageLoad();
        driver.findElement(cookieConfirmButton).click();
        WebElement element = driver.findElement(button);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(button).click();
        waiting.waitForPersonalInfoTitle();
        FillingOrderFormPersonalInfo objFillingPersonalInfoForm = new FillingOrderFormPersonalInfo(driver);
        objFillingPersonalInfoForm.fillingPersonalInfoForm(name, surname, address, metro, phoneNumber);
        waiting.waitForAboutRentTitle();
        FillingOrderFormAboutRent objFillingAboutRentForm = new FillingOrderFormAboutRent(driver);
        objFillingAboutRentForm.fillingAboutRentForm(deliveryDate, rentalPeriod, comment);
        waiting.waitForOrderConfirmWindowTitle();
        driver.findElement(yesButton).click();
        waiting.waitForOrderCompleteWindowTitle();
    }
}
