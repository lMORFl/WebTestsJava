package tests.mob;

import core.base.MobileBasePage;
import core.base.MobileBaseTest;
import core.pages.mob.AnonymRecoveryPageMob;
import core.pages.mob.LoginPageMob;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class WayToRecoveryByEmail extends MobileBaseTest {
    private static LoginPageMob loginPageMob;
    private static AnonymRecoveryPageMob anonymRecoveryPageMob;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        MobileBasePage mobileBasePage = new MobileBasePage();
        mobileBasePage.wayToLogin();

        loginPageMob = new LoginPageMob();
        loginPageMob.clickOnStringCantEnter();
    }

    @Test
    public void wayToRecoveryByEmail() {
        anonymRecoveryPageMob = new AnonymRecoveryPageMob();
        anonymRecoveryPageMob.clickOnButtonEmail();
    }
}
