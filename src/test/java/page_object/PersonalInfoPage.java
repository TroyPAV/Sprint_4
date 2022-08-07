package page_object;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Заполнение формы "Для кого самокат"
public class PersonalInfoPage {

    private final WebDriver driver;
    //url формы заказа
    private final String orderPageURL = "https://qa-scooter.praktikum-services.ru/order";
    //локатор названия формы "Для кого самокат"
    private final By personalInfoTitle = By.xpath(".//div[(@class = 'Order_Header__BZXOb') and (text() = 'Для кого самокат')]");
    //локатор поля ввода имени
    private final By nameField = By.xpath(".//input[@placeholder = '* Имя']");
    //локатор поля ввода фамилии
    private final By surnameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    //локатор поля ввода адреса
    private final By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //локатор поля выбора станции метро
    private final By metroField = By.xpath(".//input[@placeholder = '* Станция метро']");
    //локатор поля ввода номера телефона
    private final By phoneField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //локатор кнопки "Далее"
    private final By furtherButton = By.xpath(".//button[text() = 'Далее']");
    //локатор сообщения об ошибке поля ввода имени
    private final By nameErrorField = By.xpath(".//div[text() = 'Введите корректное имя']");
    //локатор сообщения об ошибке поля ввода фамилии
    private final By surnameErrorField = By.xpath(".//div[text() = 'Введите корректную фамилию']");
    //локатор сообщения об ошибке поля ввода адреса
    private final By addressErrorField = By.xpath(".//div[text() = 'Введите корректный адрес']");
    //локатор сообщения об ошибке поля станции метро
    private final By metroErrorField = By.xpath(".//div[text() = 'Выберите станцию']");
    //локатор сообщения об ошибке поля ввода номера телефона
    private final By phoneErrorField = By.xpath(".//div[text() = 'Введите корректный номер']");

    //конструктор класса
    public PersonalInfoPage(WebDriver driver) {
        this.driver = driver;
    }
    //метод вызова страницы формы заказа самоката
    public void getScooterOrderPage() {
        driver.get(orderPageURL);
    }
    //метод ожидания появления названия формы "Для кого самокат"
    public void waitForPersonalInfoTitle() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(personalInfoTitle));
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
    //метод выбора станции метро
    public void setMetro(String metro) {
        driver.findElement(metroField).click();
        //локатор станции метро
        String metroStation = ".//button//div[text() = '%s']";
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
    //метод проверки отображения сообщения об ошибке поля ввода
    public void isErrorDisplayed(By errorField) {
        Assert.assertTrue(driver.findElement(errorField).isDisplayed());
    }
    //метод получения локатора сообщения об ошибке поля имени
    public By getNameError() {
        return nameErrorField;
    }
    //метод получения локатора сообщения об ошибке поля фамилии
    public By getSurnameError() {
        return surnameErrorField;
    }
    //метод получения локатора сообщения об ошибке поля адреса
    public By getAddressError() {
        return addressErrorField;
    }
    //метод получения локатора сообщения об ошибке поля метро
    public By getMetroError() {
        return metroErrorField;
    }
    //метод получения локатора сообщения об ошибке поля телефона
    public By getPhoneError() {
        return phoneErrorField;
    }

    //метод заполнения формы заказа
    public void fillingPersonalInfoForm(String name, String surname, String address, String metro, String phoneNumber){
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetro(metro);
        setPhoneNumber(phoneNumber);
    }
}
