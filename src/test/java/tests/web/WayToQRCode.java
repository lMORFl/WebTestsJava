package tests.web;

import core.base.BaseTest;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class WayToQRCode extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        //Принятие cookies и политики
        loginPage = new LoginPage();
        loginPage.acceptCookie();
    }
    @Test
    public void WayToQRCodeTest(){
        loginPage.isButtonQRCodeVisible();
        System.out.println(); //в режиме дебага на sout делается пауза, после которых он не возвращает к полям логина и пароля
        loginPage.clickOnButtonQRCode();
        System.out.println();
        loginPage.isQRCodeVisible();
    }
}
