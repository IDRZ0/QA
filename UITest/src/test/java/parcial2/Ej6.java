package parcial2;

import org.junit.Assert;
import org.junit.Test;
import pomPages.todoist.*;

public class Ej6 extends ExamenBase {
    LoginPage1 loginPage1 = new LoginPage1();
    LoginPage2 loginPage2 = new LoginPage2();
    MainPage mainPage = new MainPage();
    StartPage startPage = new StartPage();
    ThemePage themePage = new ThemePage();
    SettingsPage settingsPage = new SettingsPage();

    String email = "ignacio@prueba5.com";
    String name = "ignacio";
    String password = "qaPRUEBA2021";

    @Test
    public void verify_register_login_update() throws InterruptedException {
        startPage.getStarted.click();
        this.waitOnSecond(2);

        loginPage1.emailBox.set(email);
        loginPage1.registerButton.click();
        this.waitOnSecond(2);

        loginPage2.nameBox.set(name);
        loginPage2.pwdBox.set(password);
        loginPage2.registerButton2.click();
        this.waitOnSecond(3);

        themePage.open.click();
        this.waitOnSecond(5);

        mainPage.profileImage.click();
        this.waitOnSecond(2);
        Assert.assertEquals("No se logeo correctamente", name, mainPage.username.getText());

        mainPage.logoutButton.click();
        this.waitOnSecond(3);
        Assert.assertTrue("No salio", startPage.getStarted.controlIsDisplayed());
    }
}
