package page_object;

import main_page_elements.PageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// Ожидания загрузки форм и окон
public class Waitings extends PageElements{

    private final WebDriver driver;
    //конструктор класса
    public Waitings(WebDriver driver) {
        this.driver = driver;
    }
    //мотод ожидания появления названия формы "Для кого самокат"
    public void waitForPersonalInfoTitle() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(personalInfoTitle));
    }
    //мотод для ожидания появления названия формы "Про аренду"
    public void waitForAboutRentTitle() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(aboutRentTitle));
    }
    //метод для ожидания появления названия окна "Хотите оформить заказ?"
    public void waitForOrderConfirmWindowTitle() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(orderConfirmWindowTitle));
    }

    //метод для ожидания появления названия окна "Заказ оформлен"
    public void waitForOrderCompleteWindowTitle(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(orderCompleteWindowTitle));
    }
    //метод для ожидания загрузки логотипа Яндекса на главной странице Яндекса
    public void waitForMainYandexPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("home-logo__default")));
    }
    //метод для ожидания кликабельности поля ввода номера заказа
    public void waitForOrderNumberFieldIsClickable() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(orderNumberField));
    }
    //метод для ожидания загрузки лендинга самоката
    public void waitForScooterMainPageLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(mainPageText));
    }
}
