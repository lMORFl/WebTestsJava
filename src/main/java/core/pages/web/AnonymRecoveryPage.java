package core.pages.web;

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
    private SelenideElement buttonServiceSupport = $("[data-l='t,support']");
    private SelenideElement chatServiceSupport = $("[data-tsid='supportChatTitle']");
    private SelenideElement closeChatServiceSupport = $("[data-icon-name='ico_close_16']");
    private SelenideElement buttonYes = $x("//button[normalize-space()='Да']");

    @Step("Проверяем, что надпись \"Восcтановление доступа\" видна")
    public boolean isStringOfRecoveryVisible() { return stringOfRecovery.shouldBe(visible).exists(); }

    @Step("Проверяем, кнопки путей восстановления видимы")
    public void buttonsRecoveryWays() {
        buttonTelephone.shouldBe(visible);
        buttonEmail.shouldBe(visible);
        buttonServiceSupport.shouldBe(visible);
    }

    @Step("Переходим на восстановление через телефон")
    public void clickOnButtonTelephone(){
        buttonTelephone.shouldBe(exist).click();
    }

    @Step("Переходим на восстановление через Email")
    public void clickOnButtonEmail(){
        buttonEmail.shouldBe(exist).click();
    }

    @Step("Открываем окно службы поддержки")
    public void clickButtonServiceSupport() { buttonServiceSupport.shouldBe(visible).click(); }

    @Step("Проверяем появление окна чат с поддержкой")
    public boolean isChatServiceSupportVisible() { return chatServiceSupport.shouldBe(visible).exists(); }

    @Step("Закрываем чат с поддержкой")
    public void closeChatServiceSupport() { closeChatServiceSupport.shouldBe(visible).click(); }

    @Step("Подтверждаем закрытие чата")
    public void acceptCloseChat() { buttonYes.shouldBe(visible).click(); }


}
