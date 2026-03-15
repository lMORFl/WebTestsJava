package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecoveryPassByTelephonePage extends BasePage {
    private SelenideElement title = $x("//div[normalize-space()='Укажите телефон']");
    private SelenideElement inputFieldNumber = $("[name='st.r.phone']");
    private SelenideElement dropCountryList = $x("//div[@data-l='t,country']");
    private SelenideElement stringOfError = $x("//div[normalize-space()='Неправильный номер телефона.']");
    private SelenideElement buttonGetCode = $("[data-l='t,submit']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления через телефон")
    private void verifyPageElements() {
        title.shouldBe(visible);
        inputFieldNumber.shouldBe(visible);
        dropCountryList.shouldBe(visible);
        buttonGetCode.shouldBe(visible);
    }

    @Step("Проверяем видимость строки заголовка")
    public boolean isTitleVisible() {
        return title.shouldBe(visible).exists();
    }

    @Step("Получаем текст заголовка")
    public String getTitleText() {
        return title.shouldBe(visible).getText();
    }

    @Step("Выбираем код страны по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        dropCountryList.click();
        SelenideElement countryItem = $x(String.format(".country-select_i[data-name='%s']",countryName));
        countryItem.scrollTo();
        String countryCode = countryItem.find(".country-select_code").text();
        countryItem.click();
        return countryCode;
    }

//    @Step("Вводим некорректный номер телефона")
//    public void enterWrongNumber(String number) {
//        inputFieldNumber.shouldBe(visible).click();
//        inputFieldNumber.shouldBe(visible).setValue(number);
//        buttonGetCode.shouldBe(visible).click();
//    }

    @Step("Кликаем по кнопке \"Получить код\"")
    public void clickOnButtonGetCode() {
        buttonGetCode.shouldBe(visible).click();
    }


    @Step("Проверяем видимость строки ошибки")
    public boolean isStringOfErrorVisible() {
        return stringOfError.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке")
    public String getStringOfErrorText() {
        return stringOfError.shouldBe(visible).getText();
    }

}
