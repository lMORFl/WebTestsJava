package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPageMob extends MobileBasePage {
    protected SelenideElement fieldEmail = $("[name='st.email']");
    protected SelenideElement fieldPassword = $("[name='st.password']");
    protected SelenideElement buttonLogin = $x("//button[@label='Войти']");
    protected SelenideElement stringCantEnter = $x("//button[@aria-label='Не получается войти?']");
    protected SelenideElement stringErrorWriteLogin = $x("//span[normalize-space()='Введите логин']");
    protected SelenideElement stringErrorWritePassword = $x("//span[normalize-space()='Введите пароль']");


    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        fieldEmail.shouldBe(visible);
        fieldPassword.shouldBe(visible);
        buttonLogin.shouldBe(visible);
        stringCantEnter.shouldBe(visible);
    }

    @Step("Вводим логин: {user}")
    public void enterLogin(String user, String password) {
        fieldEmail.shouldBe(visible).click();
        fieldEmail.shouldBe(visible).setValue(user);
        fieldPassword.shouldBe(visible).click();
        fieldPassword.shouldBe(visible).setValue(password);
    }

//    @Step("Вводим пароль: {password}")
//    public void enterPassword(String password) {
//        fieldPassword.shouldBe(visible).click();
//        fieldPassword.shouldBe(visible).setValue(password);
//    }

    @Step("Клик по кнопке \"Войти\"")
    public void clickButtonLogin() {
        buttonLogin.shouldBe(visible).click();
    }

    @Step("Проверяем видимость строки об ошибке \"Введите логин\"")
    public boolean isStringErrorLoginVisible() {
        return stringErrorWriteLogin.shouldBe(visible).exists();
    }

    public String getStringErrorLoginText() {
        return stringErrorWriteLogin.shouldBe(visible).getText();
    }

    @Step("Проверяем видимость строки об ошибке \"Введите пароль\"")
    public boolean isStringErrorPasswordVisible() {
        return stringErrorWritePassword.shouldBe(visible).exists();
    }

    public String getStringErrorPasswordText() {
        return stringErrorWritePassword.shouldBe(visible).getText();
    }

    public void clickOnStringCantEnter() {
        stringCantEnter.shouldBe(visible).click();
    }
}
