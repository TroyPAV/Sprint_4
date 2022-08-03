package page_object;

import main_page_elements.PageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//Заполнение формы "Для кого самокат"
public class FillingOrderFormPersonalInfo extends PageElements {

    private final WebDriver driver;

    //конструктор класса
    public FillingOrderFormPersonalInfo(WebDriver driver) {
        this.driver = driver;
    }
    //метод заполнения поля ввода имени
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    //метод заполнения поля фамилии
    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }
    //метод заполнения подя адреса
    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    //медод выбора станции метро
    public void setMetro(String metro) {
        driver.findElement(metroField).click();
        driver.findElement(By.xpath(String.format(metroStation, metro))).click();
    }
    //метод заполнения поля номера телефона
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }
    //метод клика по кнопке "Далее"
    public void clickFurtherBotton() {
        driver.findElement(furtherButton).click();
    }
    //метод заполнения формы заказа
    public void fillingPersonalInfoForm(String name, String surname, String address, String metro, String phoneNumber){
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetro(metro);
        setPhoneNumber(phoneNumber);
        clickFurtherBotton();
    }
}
