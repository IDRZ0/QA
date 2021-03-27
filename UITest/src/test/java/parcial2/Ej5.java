package parcial2;

import org.junit.Assert;
import org.junit.Test;
import pomPages.todoLy.*;
import testClean.TodoLyBaseTest;

public class Ej5 extends TodoLyBaseTest {
    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();
    MenuSection menuSection = new MenuSection();
    LeftSection leftSection = new LeftSection();
    CenterSection centerSection = new CenterSection();
    String email = "ignacio@prueba.com";
    String password = "1234";

    @Test
    public void verify_login_recycler_todoly() throws InterruptedException {
        mainPage.loginImage.click();
        loginModal.emailTextBox.set(email);
        loginModal.pwdTextBox.set(password);
        loginModal.loginButton.click();
        this.waitOnSecond(2);
        Assert.assertTrue("No se logeo", menuSection.logoutButton.controlIsDisplayed());

        leftSection.recyclerButton.click();
        leftSection.scroll.click();
        leftSection.emptyButton.click();
        this.waitOnSecond(2);
        Assert.assertTrue("No se vacio el basurero", centerSection.emptyVerification.controlIsDisplayed());
    }
}
