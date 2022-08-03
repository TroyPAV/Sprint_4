package main_page_elements;

import org.openqa.selenium.By;

public class PageElements {

    //URL главной страницы Яндекса
    public static final String yandexURL = "https://yandex.ru/";

    //СПИСОК ЭЛЕМЕНТОВ ЛЕНДИНГА
    //URL начальной страницы Самоката
    public static final String pageURL = "https://qa-scooter.praktikum-services.ru/";
    //локатор кнопки-логотипа "Самоката", при клике возвращает на главную страницу
    public static final By scooterLogo = By.className("Header_LogoScooter__3lsAR");
    //локатор поля "Самокат на пару дней"
    public static final By mainPageText = By.xpath(".//div[@class = 'Home_Header__iJKdX']");
    //локатор кнопки-логотипа главной страницы Яндекса
    public static final By yandexLogo = By.className("Header_LogoYandex__3TSOI");
    //локатор кнопки принятия Cookie
    public static final By cookieConfirmButton = By.id("rcc-confirm-button");
    //локатор верхней кнопки "Заказать"
    public static final By topOrderButton = By.className("Button_Button__ra12g");
    //локатор нижней кнопки "Заказать"
    public static final By bottomOrderButton = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM') and (text() = 'Заказать')]");
    //локатор кнопки "Статус заказа"
    public static final By orderStatusButton = By.xpath(".//button[@class = 'Header_Link__1TAG7']");
    //локатор поля ввода номера заказа
    public static final By orderNumberField = By.xpath(".//input[@placeholder = 'Введите номер заказа']");
    //локатор кнопки "Go!"
    public static final By goButton = By.xpath(".//button[text() = 'Go!']");
    //локатор картинки "Такого заказа нет"
    public static final By notFountImg = By.cssSelector("[alt = 'Not found']");
    //локаторы вопросов списка "Вопросы о важном"
    public static final By questionId1 = By.id("accordion__heading-0");
    public static final By questionId2 = By.id("accordion__heading-1");
    public static final By questionId3 = By.id("accordion__heading-2");
    public static final By questionId4 = By.id("accordion__heading-3");
    public static final By questionId5 = By.id("accordion__heading-4");
    public static final By questionId6 = By.id("accordion__heading-5");
    public static final By questionId7 = By.id("accordion__heading-6");
    public static final By questionId8 = By.id("accordion__heading-7");
    //локатор элементов ответов в выпадающем списке "Воросы о важном"
    public static final String answerXpath = ".//p[text()='%s']";

    //СПИСОК ЭЛЕМЕНТОВ ФОРМЫ "ДЛЯ КОГО САМОКАТ"
    //локатор названия формы "Для кого самокат"
    public static final By personalInfoTitle = By.xpath(".//div[(@class = 'Order_Header__BZXOb') and (text() = 'Для кого самокат')]");

    //локатор поля ввода имени
    public static final By nameField = By.xpath(".//input[@placeholder = '* Имя']");
    //локатор поля ввода фамилии
    public static final By surnameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    //локатор поля ввода адреса
    public static final By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //локатор поля выбора станции метро
    public static final By metroField = By.xpath(".//input[@placeholder = '* Станция метро']");
    //локатор станции метро
    public static final String metroStation = ".//button//div[text() = '%s']";
    //локатор поля ввода номера телефона
    public static final By phoneField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //локатор кнопки "Далее"
    public static final By furtherButton = By.xpath(".//button[text() = 'Далее']");
    //локатор сообщения об ошибке поля ввода имени
    public static final By nameErrorField = By.xpath(".//div[text() = 'Введите корректное имя']");
    //локатор сообщения об ошибке поля ввода фамилии
    public static final By surnameErrorField = By.xpath(".//div[text() = 'Введите корректную фамилию']");
    //локатор сообщения об ошибке поля ввода адреса
    public static final By addressErrorField = By.xpath(".//div[text() = 'Введите корректный адрес']");
    //локатор сообщения об ошибке поля станции метро
    public static final By metroErrorField = By.xpath(".//div[text() = 'Выберите станцию']");
    //локатор сообщения об ошибке поля ввода номера телефона
    public static final By phoneErrorField = By.xpath(".//div[text() = 'Введите корректный номер']");

    //СПИСОК ЭЛЕМЕНТОВ ФОРМЫ "ПРО АРЕНДУ"
    //локатор названия формы "Про аренду"
    public static final By aboutRentTitle = By.xpath(".//div[(@class = 'Order_Header__BZXOb') and (text() = 'Про аренду')]");
    //локатор поля "Когда привезти самокат"
    public static final By deliveryDateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //локатор стрелки открытия списка возможных сроков аренды
    public static final By dropdownArrow = By.xpath(".//span[@class = 'Dropdown-arrow']");
    //локатор срока аренды
    public static final String period = ".//div[text() = '%s']";
    //локатор чекбокса цвета самоката "Черный жемчуг"
    public static final By blackColour = By.id("black");
    //локатор чекбокса цвета самоката "Серая безысходность"
    public static final By greyColour = By.id("grey");
    //локатор поля ввода комментария для курьера
    public static final By commentForCourier = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //локатор для кнопки "Заказать"
    public static final By orderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    //СПИСОК ЭЛЕМЕНТОВ ОКНА ПОТВЕРЖДЕНИЯ ОФОРМЛЕНИЯ ЗАКАЗА
    //локатор названия окна подтверждения оформления заказа
    public static final By orderConfirmWindowTitle = By.xpath(".//div[(@class = 'Order_ModalHeader__3FDaJ') and (text() = 'Хотите оформить заказ?')]");
    //локатор кнопки "Да"
    public static final By yesButton = By.xpath(".//button[text() = 'Да']");

    //СПИСОК ЭЛЕМЕНТОВ ОКНА "ЗАКАЗ ОФОРМЛЕН"
    //локатор названия окна "заказ оформлен"
    public static final By orderCompleteWindowTitle = By.xpath(".//div[(@class = 'Order_ModalHeader__3FDaJ') and (text() = 'Заказ оформлен')]");

}
