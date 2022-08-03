import io.github.bonigarcia.wdm.WebDriverManager;
import main_page_elements.PageElements;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page_object.Waitings;

@RunWith(Parameterized.class)
public class QuestionsAboutImportantTest extends PageElements{
    WebDriver driver;
    private final By questionId;
    private final String answerText;

    public QuestionsAboutImportantTest(By questionId, String answerText) {
        this.questionId = questionId;
        this.answerText = answerText;
    }

    @Parameterized.Parameters
    public static Object[][] getTestAnswers() {
        return new Object[][] {
                {questionId1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {questionId2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {questionId3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {questionId4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {questionId5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {questionId6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {questionId7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {questionId8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
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
        driver.get(pageURL);
        Waitings waiting = new Waitings(driver);
        waiting.waitForScooterMainPageLoad();
        driver.findElement(cookieConfirmButton).click();
        WebElement element = driver.findElement(questionId);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(questionId).click();
        String xpathToAnswerText = String.format(answerXpath, answerText);
        Assert.assertTrue(driver.findElement(By.xpath(xpathToAnswerText)).isDisplayed());
    }
}
