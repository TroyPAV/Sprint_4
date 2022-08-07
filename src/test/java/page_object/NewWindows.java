package page_object;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// Ожидания загрузки форм и окон
public class NewWindows {

    private final WebDriver driver;
    //локатор названия окна подтверждения оформления заказа
    private final By orderConfirmWindowTitle = By.xpath(".//div[(@class = 'Order_ModalHeader__3FDaJ') and (text() = 'Хотите оформить заказ?')]");
    //локатор кнопки "Да"
    private final By yesButton = By.xpath(".//button[text() = 'Да']");
    //локатор названия окна "заказ оформлен"
    private final By orderCompleteWindowTitle = By.xpath(".//div[(@class = 'Order_ModalHeader__3FDaJ') and (text() = 'Заказ оформлен')]");

    //конструктор класса
    public NewWindows(WebDriver driver) {
        this.driver = driver;
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
    public void isYandexPageDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("home-logo__default")));
        Assert.assertEquals("https://yandex.ru/", driver.getCurrentUrl());
    }
    //метод нажатия кнопки "Да"
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    //метод перехода на последнюю открытую вкладку
    public void newTab() {
        for (String tab: driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }
}
