package testClean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pomPages.todoLy.CenterSection;
import pomPages.todoLy.LeftSection;
import pomPages.todoLy.LoginModal;
import pomPages.todoLy.MainPage;
import singletonSession.Session;

public class CRUDProjectTest {
    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();
    LeftSection leftSection = new LeftSection();
    CenterSection centerSection = new CenterSection();
    String user = "upbui@upbui.com";
    String pwd = "1234";
    String name = "IgnacioProjectClean";
    String updateName = "IgnacioProjectCleanUpdate";

    @Test
    public void verify_crud_project_todoly() throws InterruptedException {
        //login
        Session.getSession().getDriver().get("http://todo.ly/");
        mainPage.loginImage.click();
        loginModal.loginAction(user, pwd);
        //create
        leftSection.addNewProjectButton.click();
        leftSection.nameProjectTextBox.set(name);
        leftSection.addButton.click();
        Thread.sleep(2000);
        Assert.assertEquals("Proyecto no se creo", name, centerSection.projectNameLabel.getText());
        //update
        leftSection.currentProject.click();
        leftSection.scroll.click();
        leftSection.editButton.click();
        leftSection.editProjectName.clear();
        leftSection.editProjectName.set(updateName);
        leftSection.saveButton.click();
        Thread.sleep(2000);
        Assert.assertEquals("No se edito el proyecto", updateName, centerSection.projectNameLabel.getText());
        //delete
        leftSection.currentProject.click();
        leftSection.scroll.click();
        leftSection.deleteButton.click();
        Session.getSession().getDriver().switchTo().alert().accept();
        Thread.sleep(2000);
        Assert.assertNotEquals("No se borro", updateName, centerSection.projectNameLabel.getText());
    }

    @After
    public void close() {
        Session.getSession().closeSession();
    }
}
