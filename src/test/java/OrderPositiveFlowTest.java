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

import page_object.AboutRentPage;
import page_object.NewWindows;
import page_object.PersonalInfoPage;
import page_object.MainPage;

@RunWith(Parameterized.class)
public class OrderPositiveFlowTest {

    private static WebDriver driver;
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
        MainPage objButtons = new MainPage(driver);
        return new Object[][] {
                {objButtons.getTopButton(),"Иван", "Иванов", "ул.Ивановская 12", "Сокольники", "+79213456789", "10.10.2022", "сутки", "Комментарий 1"},
                {objButtons.getBottomButton(),"Иван", "Иванов", "ул.Ивановская 12", "Сокольники", "+79213456789", "10.10.2022", "сутки", "Комментарий 1"},
                {objButtons.getTopButton(),"Афанасий", "Петров", "ул.Стародеревенская 21", "Чистые пруды", "89219876543", "31.12.2022", "двое суток", "Комментарий 21"},
                {objButtons.getBottomButton(),"Афанасий", "Петров", "ул.Стародеревенская 21", "Чистые пруды", "89219876543", "31.12.2022", "двое суток", "Комментарий 21"},
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
    public void orderTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.getScooterMainPage();
        objMainPage.waitForScooterMainPageLoad();
        objMainPage.cookieConfirm();
        objMainPage.clickOrderButtons(button);
        PersonalInfoPage objPersonalInfoPage = new PersonalInfoPage(driver);
        objPersonalInfoPage.waitForPersonalInfoTitle();
        objPersonalInfoPage.fillingPersonalInfoForm(name, surname, address, metro, phoneNumber);
        objPersonalInfoPage.clickFurtherBotton();
        AboutRentPage objAboutRentPage = new AboutRentPage(driver);
        objAboutRentPage.waitForAboutRentTitle();
        objAboutRentPage.fillingAboutRentForm(deliveryDate, rentalPeriod, comment);
        objAboutRentPage.clickOrderButton();
        NewWindows objNewWindows = new NewWindows(driver);
        objNewWindows.waitForOrderConfirmWindowTitle();
        objNewWindows.clickYesButton();
        objNewWindows.waitForOrderCompleteWindowTitle();
    }
}
