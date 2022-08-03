package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Заполнение формы "Про аренду"
public class AboutRentPage {

    private final WebDriver driver;
    //локатор названия формы "Про аренду"
    private final By aboutRentTitle = By.xpath(".//div[(@class = 'Order_Header__BZXOb') and (text() = 'Про аренду')]");
    //локатор поля "Когда привезти самокат"
    private final By deliveryDateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //локатор стрелки открытия списка возможных сроков аренды
    private final By dropdownArrow = By.xpath(".//span[@class = 'Dropdown-arrow']");
    //локатор чекбокса цвета самоката "Черный жемчуг"
    private final By blackColour = By.id("black");
    //локатор чекбокса цвета самоката "Серая безысходность"
    private final By greyColour = By.id("grey");
    //локатор поля ввода комментария для курьера
    private final By commentForCourier = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //локатор для кнопки "Заказать"
    private final By orderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    //конструктор класса
    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод для ожидания появления названия формы "Про аренду"
    public void waitForAboutRentTitle() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(aboutRentTitle));
    }
    //метод заполнения поля даты доставки заказа
    public void setDeliveryDate(String deliveryDate) {
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
    }
    //метод выбора длительности аренды
    public void setRentDuration(String rentalPeriod) {
        driver.findElement(dropdownArrow).click();
        //локатор срока аренды
        String period = ".//div[text() = '%s']";
        driver.findElement(By.xpath(String.format(period, rentalPeriod))).click();
    }
    //метод выбора чекбокса черного цвета самоката
    public void setBackColour() {
        driver.findElement(blackColour).click();
    }
    //метод выбора чекбокса серого цвета самоката
    public void setGreyColour() {
        driver.findElement(greyColour).click();
    }
    //метод заполнения поля комментария для курьера
    public void setCommentField(String comment) {
        driver.findElement(commentForCourier).sendKeys(comment);
    }
    //метод клика по кнопке "Заказать"
    public  void clickOrderButton(){
        driver.findElement(orderButton).click();
    }
    //метод заполнения формы "Про аренду"
    public void fillingAboutRentForm(String deliveryDate, String rentalPeriod, String comment) {
        setDeliveryDate(deliveryDate);
        setRentDuration(rentalPeriod);
        setBackColour();
        setGreyColour();
        setCommentField(comment);
    }
}
