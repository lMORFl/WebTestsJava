package tests.mob;

import core.base.MobileBasePage;
import core.base.MobileBaseTest;
import core.pages.mob.AnonymRecoveryPageMob;
import core.pages.mob.LoginPageMob;
import core.pages.mob.RecoveryByTelephoneMob;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class WayToRecoveryByTelephone extends MobileBaseTest {
    private static LoginPageMob loginPageMob;
    private static AnonymRecoveryPageMob anonymRecoveryPageMob;
    private static RecoveryByTelephoneMob recoveryByTelephoneMob;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        MobileBasePage mobileBasePage = new MobileBasePage();
        mobileBasePage.acceptCookie();
        mobileBasePage.wayToLogin();

        loginPageMob = new LoginPageMob();
        loginPageMob.clickOnStringCantEnter();
    }

    @Test
    public void wayToRecoveryByTelephone() {
        anonymRecoveryPageMob = new AnonymRecoveryPageMob();
        anonymRecoveryPageMob.clickOnButtonTelephone();

        recoveryByTelephoneMob = new RecoveryByTelephoneMob();
        recoveryByTelephoneMob.selectCountryByName("Монако");
        recoveryByTelephoneMob.enterWrongNumber("3");
//        recoveryByTelephoneMob.clickOnButtonGetCode();
        recoveryByTelephoneMob.isStringOfErrorVisible();


    }
}
