package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private SelenideElement usernameField = $("[name='st.email']");
    private SelenideElement passwordField = $("[name='st.password']");
    private SelenideElement loginButton = $("button[label='Войти']");
    private SelenideElement forgotPasswordLink = $x("//button[@aria-label='Не получается войти?']");
    private SelenideElement registrationButton = $x("//button[.//span[normalize-space()='Зарегистрироваться']]");

    //Локаторы для кнопок соцсетей
    private SelenideElement vkButton = $("[data-l='t,vkc']");
    private SelenideElement googleButton = $("[data-l='t,google']");
    private SelenideElement mailRuButton = $("[data-l='t,mailru']");

    //Локатор для элемента с сообщением об ошибке входа
    private SelenideElement errorMessageLoginNPass = $x("//span[normalize-space()='Неправильно указан логин и/или пароль']");
    private SelenideElement errorMessageLogin = $x("//span[normalize-space()='Введите логин']");
    private SelenideElement errorMessagePass = $x("//span[normalize-space()='Введите пароль']");

    //Кнопка восстановить пароль
    private SelenideElement buttonRecovery = $x("//a//span[text()='Восстановить']/..");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        googleButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessageLoginNPass.shouldBe(visible).exists();
    }

    @Step("Проверяем видимость сообщения об ошибке входа (логин)")
    public boolean isErrorMessageLoginVisible() { return errorMessageLogin.shouldBe(visible).exists(); }

    @Step("Проверяем видимость сообщения об ошибке входа (пароль)")
    public boolean isErrorMessagePassVisible() { return errorMessagePass.shouldBe(visible).exists(); }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessageLoginNPass.shouldBe(visible).getText();
    }

    @Step("Получаем текст сообщения об ошибке входа (логин)")
    public String getErrorMessageLoginText() {
        return errorMessageLogin.shouldBe(visible).getText();
    }

    @Step("Получаем текст сообщения об ошибке входа (пароль)")
    public String getErrorMessagePassText() {
        return errorMessagePass.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином: {username} и паролем: {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPassword() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переходим на страницу регистрации")
    public void openRegistrationPage() {
        registrationButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Вконтакте")
    public void loginWithVK() {
        vkButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Google")
    public void loginWithGoogle() {
        googleButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Mail.ru")
    public void loginWithMailRu()
    {
        mailRuButton.shouldBe(visible).click();
    }

    @Step("Проверяем видимость кнопки \"/Востановить\"")
    public boolean getButtonRecovery() { return buttonRecovery.shouldBe(visible).exists(); }

    @Step("Переходим на страницу восстановления пароля")
    public void openRecoveryPage() { buttonRecovery.shouldBe(visible).click(); }

}
