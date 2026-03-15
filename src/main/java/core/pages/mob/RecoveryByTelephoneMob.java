package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RecoveryByTelephoneMob extends MobileBasePage {
    private SelenideElement chooseCountry = $("[id='countryName']");
    private SelenideElement listCountry = $x("//a[@class='reg_sel-country_link']");
    private SelenideElement fieldNumber = $x("//input[@name='rfr.phone']");
    private SelenideElement buttonGetCode = $x("//input[@id='getCode']");
    private SelenideElement stringErrorNumber = $x("//label[normalize-space()='Введен неверный номер телефона']");

    {
        verifyPageElements();
    }

    private void verifyPageElements() {
        chooseCountry.shouldBe(visible);
        buttonGetCode.shouldBe(visible);
    }
    @Step("Выбираем код страны по названию: {countryName}")
    public void selectCountryByName(String countryName) {
        listCountry.click();
        SelenideElement countryItem = $x(String.format("//div[@class='reg_choose_country' and text()='%s']",countryName));
//        countryItem.scrollTo();
//        не знаю чем взять префикс номера, find берет только селекторы, а в данном случае получается только xPath взять
//        String countryCode = countryItem.find("//div[@class='reg_choose_prefix']").text();
        countryItem.click();
//        return countryCode;
    }

    @Step("Вводим некорректный номер телефона")
    public void enterWrongNumber(String number) {
        fieldNumber.shouldBe(visible).click();
        fieldNumber.shouldBe(visible).setValue(number);
        buttonGetCode.shouldBe(visible).click();
    }

//    @Step("Кликаем по кнопке \"Получить код\"")
//    public void clickOnButtonGetCode() {
//        buttonGetCode.shouldBe(visible).click();
//    }


    @Step("Проверяем видимость строки ошибки")
    public boolean isStringOfErrorVisible() {
        return stringErrorNumber.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке")
    public String getStringOfErrorText() {
        return stringErrorNumber.shouldBe(visible).getText();
    }
}
