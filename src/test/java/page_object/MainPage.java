package page_object;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    //локатор поля "Самокат на пару дней"
    private final By mainPageText = By.xpath(".//div[@class = 'Home_Header__iJKdX']");
    //локатор кнопки-логотипа главной страницы Яндекса
    private final By yandexLogo = By.className("Header_LogoYandex__3TSOI");
    //локатор кнопки-логотипа "Самоката", при клике возвращает на главную страницу
    private final By scooterLogo = By.className("Header_LogoScooter__3lsAR");
    //локатор кнопки принятия Cookie
    private final By cookieConfirmButton = By.id("rcc-confirm-button");
    //локатор поля ввода номера заказа
    private final By orderNumberField = By.xpath(".//input[@placeholder = 'Введите номер заказа']");
    //локатор кнопки "Статус заказа"
    private final By orderStatusButton = By.xpath(".//button[@class = 'Header_Link__1TAG7']");
    //локатор кнопки "Go!"
    private final By goButton = By.xpath(".//button[text() = 'Go!']");
    //локатор картинки "Такого заказа нет"
    private final By notFountImg = By.xpath(".//img[@alt = 'Not found']");

    //конструктор класса
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //метод для ожидания загрузки лендинга самоката
    public void waitForScooterMainPageLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(mainPageText));
    }
    //метод клика на лого "Самоката"
    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }
    //метод клика на лого "Яндекса"
    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }
    //метод проверки отображения главной страницы
    public void isMainPageDisplayed(String mainPageUrl) {
        Assert.assertEquals(mainPageUrl, driver.getCurrentUrl());
    }
    //метод принятия сообщения об использоввании Cookie
    public void cookieConfirm() {
        driver.findElement(cookieConfirmButton).click();
    }
    //метод для ожидания кликабельности поля ввода номера заказа
    public void waitForOrderNumberFieldIsClickable() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(orderNumberField));
    }
    //метод клика по кнопке Статус заказа
    public void clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
    }
    //метод ввода символов в поле статус заказа
    public void setOrderNumber(String orderNumber) {
        driver.findElement(orderNumberField).sendKeys(orderNumber);
    }
    //метод клика по кнопке "Go!"
    public void clickGoButton() {
        driver.findElement(goButton).click();
    }
    //метод ожидания и подтверждения появления картинки "Такого заказа нет"
    public void isDisplayedErrorImg() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(notFountImg));
        Assert.assertTrue(driver.findElement(notFountImg).isDisplayed());
    }
    //метод клика на кнопки "Заказать" (вехнюю и нижнюю)
    public void clickOrderButtons(By button) {
        WebElement element = driver.findElement(button);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(button).click();
    }
    //метод клика на вопросы в списке "Вопросы о важном"
    public void clickQuestionButtons(String questionId) {
        WebElement element = driver.findElement(By.id(questionId));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id(questionId)).click();
    }
    //метод сравнения текста в ответах на "Вопросы о важном"
    public void isAnswerDisplayed(String answerText) {
        String xpathToAnswerText = String.format(".//p[text()='%s']", answerText);
        Assert.assertTrue(driver.findElement(By.xpath(xpathToAnswerText)).isDisplayed());
    }

}
