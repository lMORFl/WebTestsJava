package tests.web;

import core.base.BaseTest;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithOnlyWrongPassword extends BaseTest {

    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        //Принятие cookies и политики
        loginPage = new LoginPage();
        loginPage.acceptCookie();
        //у меня не появляется окно с Privacy
//        loginPage.acceptPrivacyButton();
    }

    @Test
    public void loginWithOnlyWrongPassword() {
        //Попытка входа с некорректными данными
        loginPage.login(null, "incorrectPass");

        //Проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMessageLoginVisible(), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введите логин";
        String actualErrorMessage = loginPage.getErrorMessageLoginText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}
