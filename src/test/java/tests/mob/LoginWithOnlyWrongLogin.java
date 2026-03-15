package tests.mob;

import core.base.MobileBasePage;
import core.base.MobileBaseTest;
import core.pages.mob.LoginPageMob;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithOnlyWrongLogin extends MobileBaseTest {

    private static LoginPageMob loginPageMob;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        MobileBasePage mobileBasePage = new MobileBasePage();
        mobileBasePage.wayToLogin();
        loginPageMob = new LoginPageMob();
    }

    @Test
    public void EnterOnlyWrongLogin() {
        loginPageMob.enterLogin("incorrectUser", null);
        loginPageMob.clickButtonLogin();
        loginPageMob.isStringErrorPasswordVisible();

        assertTrue(loginPageMob.isStringErrorPasswordVisible(), "Сообщение об ошибке входа не отображается");

        String expectedErrorMessage = "Введите пароль";
        String actualErrorMessage = loginPageMob.getStringErrorPasswordText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}
