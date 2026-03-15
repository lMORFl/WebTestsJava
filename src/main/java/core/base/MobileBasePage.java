package core.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MobileBasePage {

    protected SelenideElement buttonEnter = $x("//input[@name='loginButton']");
    protected SelenideElement buttonRegistration = $x("//input[@name='registerButton']");
    protected SelenideElement buttonAcceptCookie = $("[name='button_allow_all']");


    public void acceptCookie() {
        buttonAcceptCookie.shouldBe(visible).click();
    }

    public void wayToLogin() {
        buttonEnter.shouldBe(visible).click();
    }


}
