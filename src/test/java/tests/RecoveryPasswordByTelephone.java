package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecoveryPasswordByTelephone extends BaseTest {

        private static LoginPage loginPage;
        private static AnonymRecoveryPage anonymRecoveryPage;

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
        public void toPasswordRecoveryByTelephone() {
            //Попытка входа с некорректными данными 3 раза


            //Проверка наличия сообщения об ошибке
            for (int i = 0; i < 3; i++) {
                loginPage.login("inr", "1");
            }

            System.out.println();
            loginPage.openRecoveryPage();
            anonymRecoveryPage = new AnonymRecoveryPage();

            assertTrue(anonymRecoveryPage.isStringOfRecoveryVisible(), "Не отображается заголовок страницы");
            anonymRecoveryPage.buttonsRecoveryWays();
            anonymRecoveryPage.clickOnButtonTelephone();

        }
    }