package tests.mob;

import core.base.MobileBasePage;
import core.base.MobileBaseTest;
import core.pages.mob.LoginPageMob;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithOnlyWrongPassword extends MobileBaseTest {

    private static LoginPageMob loginPageMob;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        MobileBasePage mobileBasePage = new MobileBasePage();
        mobileBasePage.wayToLogin();
        loginPageMob = new LoginPageMob();
    }

    @Test
    public void EnterOnlyWrongPassword() {
        loginPageMob.enterLogin(null, "321123a");
        loginPageMob.clickButtonLogin();
        loginPageMob.isStringErrorLoginVisible();

        assertTrue(loginPageMob.isStringErrorLoginVisible(), "Сообщение об ошибке входа не отображается");

        String expectedErrorMessage = "Введите логин";
        String actualErrorMessage = loginPageMob.getStringErrorLoginText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}
