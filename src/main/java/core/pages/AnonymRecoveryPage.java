package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AnonymRecoveryPage extends BasePage {

    private SelenideElement stringOfRecovery = $x("//div[normalize-space()='Восстановление доступа']");
    private SelenideElement buttonTelephone = $("[data-l='t,phone']");
    private SelenideElement buttonEmail = $("[data-l='t,email']");

    @Step("Проверяем, что надпись \"Востановление доступа\" видна")
    public boolean isStringOfRecoveryVisible() { return stringOfRecovery.shouldBe(visible).exists(); }

    @Step("Проверяем, кнопки путей восстановления видимы")
    public void buttonsRecoveryWays() {
        buttonTelephone.shouldBe(visible);
        buttonEmail.shouldBe(visible);
    }

    @Step("Переходим на восстановление через телефон")
    public void clickOnButtonTelephone(){
        buttonTelephone.shouldBe(exist).click();
    }

    @Step("Переходим на восстановление через Email")
    public void clickOnButtonEmail(){
        buttonEmail.shouldBe(exist).click();
    }
}
