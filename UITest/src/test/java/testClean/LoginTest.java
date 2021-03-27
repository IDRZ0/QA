package testClean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pomPages.todoLy.LoginModal;
import pomPages.todoLy.MainPage;
import pomPages.todoLy.MenuSection;
import singletonSession.Session;

public class LoginTest extends TodoLyBaseTest {
    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();
    MenuSection menuSection = new MenuSection();
    String user = "upbui@upbui.com";
    String pwd = "1234";

    @Test
    public void verify_login_todoly() {
        mainPage.loginImage.click();
        loginModal.emailTextBox.set(user);
        loginModal.pwdTextBox.set(pwd);
        loginModal.loginButton.click();
        Assert.assertTrue("Fail login", menuSection.logoutButton.controlIsDisplayed());
    }
}
