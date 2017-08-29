package net.synaps.test;

import net.synaps.UserInfo;
import net.synaps.pages.AuthPage;
import org.junit.Test;

public class SynapsAuthTest extends TestBase {

    @Test
    public void authTest() {
        UserInfo user = new UserInfo("t7days.1@gmail.com", "123qweRT");
        new AuthPage().fillLogin(user.email).
                fillPassword(user.password).
                scrollToLoginSubmit(driver).
                clickLogin().
                checkPlaceCreate();
    }

    @Test
    public void CheckCredentialsAuthTest() {
        UserInfo user = new UserInfo("t7days.1@gmail.com", "123qweR");
        new AuthPage().fillLogin(user.email).
                fillPassword(user.password).
                scrollToLoginSubmit(driver).
                clickLoginError().
                checkErrorCredentials();
    }

}
