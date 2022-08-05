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

@RunWith(Parameterized.class)
public class QuestionsAboutImportantTest {
    private static WebDriver driver;
    private final By questionId;
    private final String answerText;

    public QuestionsAboutImportantTest(By questionId, String answerText) {
        this.questionId = questionId;
        this.answerText = answerText;
    }

    @Parameterized.Parameters
    public static Object[][] getTestAnswers() {
        MainPage objQuestionId = new MainPage(driver);
        return new Object[][] {
                {objQuestionId.getQuestionId(0), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {objQuestionId.getQuestionId(1), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {objQuestionId.getQuestionId(2), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {objQuestionId.getQuestionId(3), "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {objQuestionId.getQuestionId(4), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {objQuestionId.getQuestionId(5), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {objQuestionId.getQuestionId(6), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {objQuestionId.getQuestionId(7), "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
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

    //Тесты проверки ответов в выпадающем списке "Вопросы о важном"
    @Test
    public void questionsAboutImportantTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.getScooterMainPage();
        objMainPage.waitForScooterMainPageLoad();
        objMainPage.cookieConfirm();
        objMainPage.clickQuestionButtons(questionId);
        objMainPage.isAnswerDisplayed(answerText);
    }
}
