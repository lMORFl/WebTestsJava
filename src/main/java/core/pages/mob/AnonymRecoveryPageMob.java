package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBasePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AnonymRecoveryPageMob extends MobileBasePage {
    private SelenideElement title = $x("//h2[normalize-space()='Восстановление доступа']");
    private SelenideElement buttonTelephone = $x("//div[normalize-space()='Телефон']");
    private SelenideElement buttonEmail = $x("//div[normalize-space()='Электронная почта']");
    private SelenideElement buttonServiceSupport = $x("//div[normalize-space()='Служба поддержки']");


    {
        verifyPageElements();
    }

    private void verifyPageElements(){
        title.shouldBe(visible);
        buttonTelephone.shouldBe(visible);
        buttonEmail.shouldBe(visible);
        buttonServiceSupport.shouldBe(visible);
    }

    @Step("Кликаем на кнопку Телефон")
    public void clickOnButtonTelephone() {
        buttonTelephone.shouldBe(visible).click();
    }

    @Step("Кликаем на кнопку Электронная почта")
    public void clickOnButtonEmail() {
        buttonEmail.shouldBe().click();
    }
}
