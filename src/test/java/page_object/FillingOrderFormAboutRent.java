package page_object;

import main_page_elements.PageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//Заполнение формы "Про аренду"
public class FillingOrderFormAboutRent extends PageElements {

    private final WebDriver driver;

    //конструктор класса
    public FillingOrderFormAboutRent(WebDriver driver) {
        this.driver = driver;
    }

    //метод заполнения поля даты доставки заказа
    public void setDeliveryDate(String deliveryDate) {
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
    }
    //метод выбора длительности аренды
    public void setRentDuration(String rentalPeriod) {
        driver.findElement(dropdownArrow).click();
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
        clickOrderButton();
    }
}
