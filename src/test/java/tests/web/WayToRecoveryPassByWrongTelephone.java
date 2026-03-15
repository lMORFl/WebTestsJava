package tests.web;

import core.base.BaseTest;
import core.pages.web.AnonymRecoveryPage;
import core.pages.web.LoginPage;
import core.pages.web.RecoveryPassByTelephonePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WayToRecoveryPassByWrongTelephone extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static RecoveryPassByTelephonePage recoveryPassByTelephonePage;

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
    public void enterWrongTelephoneNumberRecovery() {
        //Попытка входа с некорректными данными 3 раза

        for (int i = 0; i < 3; i++) {
            loginPage.login("inr", "1");
        }

        loginPage.openRecoveryPage();
        anonymRecoveryPage = new AnonymRecoveryPage();

        assertTrue(anonymRecoveryPage.isStringOfRecoveryVisible(), "Не отображается заголовок страницы");
        anonymRecoveryPage.buttonsRecoveryWays();
        anonymRecoveryPage.clickOnButtonTelephone();

        recoveryPassByTelephonePage = new RecoveryPassByTelephonePage();
        assertTrue(recoveryPassByTelephonePage.isTitleVisible(), "Не отображается заголовок страницы");
        String expectedTitle = "Укажите телефон";
        String actualTitle = recoveryPassByTelephonePage.getTitleText();
        assertEquals(expectedTitle, actualTitle, "Заголовок не совпадает");

        recoveryPassByTelephonePage.selectCountryByName("Аргентина");
//        recoveryPassByTelephonePage.enterWrongNumber("1234");   //он сбивает код страны, при вводе данных чисел он указывает Канаду, а не Аргентину
        recoveryPassByTelephonePage.clickOnButtonGetCode();

        assertTrue(recoveryPassByTelephonePage.isStringOfErrorVisible(), "Не отображается строка ошибки");
        String expectedStringOfError = "Неправильный номер телефона.";
        String actualStringOfError = recoveryPassByTelephonePage.getStringOfErrorText();
        assertEquals(expectedStringOfError, actualStringOfError, "Текст ошибки не совпадает");


    }
}
