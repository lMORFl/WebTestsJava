package tests.web;

import core.base.BaseTest;
import core.pages.web.AnonymRecoveryPage;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WayToSupportService extends BaseTest {

    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        //Принятие cookies и политики
        loginPage = new LoginPage();
        loginPage.acceptCookie();
        loginPage.clickCantEnter();
    }

    @Test
    public void toServiceSupport() {

        System.out.println();
        anonymRecoveryPage = new AnonymRecoveryPage();

        assertTrue(anonymRecoveryPage.isStringOfRecoveryVisible(), "Не отображается заголовок страницы");
        anonymRecoveryPage.buttonsRecoveryWays();
        anonymRecoveryPage.clickButtonServiceSupport();
        anonymRecoveryPage.isChatServiceSupportVisible();
        anonymRecoveryPage.closeChatServiceSupport();
        anonymRecoveryPage.acceptCloseChat();

    }
}