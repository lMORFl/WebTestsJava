package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupSearch extends BasePage {

    private SelenideElement listOFGroups = $("[id='hook_Block_UserGroupsSearchPortal']");

    @Step("Проверяем появление списка групп")
    public boolean isListOfGroupsVisible() { return listOFGroups.shouldBe(visible).exists(); }
}
