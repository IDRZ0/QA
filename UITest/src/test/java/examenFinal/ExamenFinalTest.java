package examenFinal;

import org.junit.Assert;
import org.junit.Test;
import pomPages.todoLy.*;

public class ExamenFinalTest extends TestBase {
    LoginModal loginModal = new LoginModal();
    MainPage mainPage = new MainPage();
    MenuSection menuSection = new MenuSection();
    SettingsPage settingsPage = new SettingsPage();

    String user = "ignacio@prueba.com";
    String pass = "1234";
    String newPass = "12345";

    @Test
    public void changePassword() throws InterruptedException {
        mainPage.loginImage.click();

        loginModal.emailTextBox.set(user);
        loginModal.pwdTextBox.set(pass);
        loginModal.loginButton.click();

        this.waitOnSecond(1);
        menuSection.setings.click();

        settingsPage.oldPass.set(pass);
        settingsPage.newPass.set(newPass);
        this.waitOnSecond(1);
        settingsPage.save.click();

        this.waitOnSecond(1);
        menuSection.logoutButton.click();

        mainPage.loginImage.click();

        loginModal.emailTextBox.set(user);
        loginModal.pwdTextBox.set(newPass);
        loginModal.loginButton.click();

        this.waitOnSecond(2);
        Assert.assertTrue("Mal", menuSection.logoutButton.controlIsDisplayed());
    }
}
