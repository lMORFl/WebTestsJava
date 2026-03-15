package tests.web;

import core.base.BaseTest;
import core.pages.web.GroupSearch;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class EnterOnSearchField extends BaseTest {
    private static LoginPage loginPage;
    private static GroupSearch groupSearch;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        //Принятие cookies и политики
        loginPage = new LoginPage();
        loginPage.acceptCookie();
    }

    @Test
    public void wayToSearchGroup() {
        loginPage.enterWordSearchField("Тестировщик");
        loginPage.clickOnShowAllResults();
        GroupSearch groupSearch = new GroupSearch();
        groupSearch.isListOfGroupsVisible();
    }
}
