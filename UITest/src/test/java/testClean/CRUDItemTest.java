package testClean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pomPages.todoLy.CenterSection;
import pomPages.todoLy.LeftSection;
import pomPages.todoLy.LoginModal;
import pomPages.todoLy.MainPage;
import singletonSession.Session;

public class CRUDItemTest extends TodoLyBaseTest {
    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();
    LeftSection leftSection = new LeftSection();
    CenterSection centerSection = new CenterSection();
    String user = "upbui@upbui.com";
    String pwd = "1234";
    String name = "IgnacioProjectClean";
    String itemName = "IgnacioItem";
    String updateItemName = "IgnacioItemUpdate";

    @Test
    public void verify_crud_item_todoly() throws InterruptedException {
        //login
        mainPage.loginImage.click();
        loginModal.loginAction(user, pwd);
        //create
        leftSection.addNewProjectButton.click();
        leftSection.nameProjectTextBox.set(name);
        leftSection.addButton.click();
        this.waitOnSecond(2);
        Assert.assertEquals("Proyecto no se creo", name, centerSection.projectNameLabel.getText());
        //createItem
        centerSection.itemTextBox.set(itemName);
        centerSection.addItemButton.click();
        this.waitOnSecond(2);
        Assert.assertEquals("No se creo el item", itemName, centerSection.editItemName.getText());
        //updateItem
        centerSection.editItemName.click();
        centerSection.editItemNameClicked.clear();
        centerSection.editItemNameClicked.set(updateItemName);
        centerSection.editItemNameClicked.pressEnter();
        this.waitOnSecond(2);
        Assert.assertEquals("No se actualizo el item", updateItemName, centerSection.editItemName.getText());
        //deleteItem
        centerSection.editItemName.click();
        centerSection.scroll.click();
        centerSection.deleteItem.click();
        this.waitOnSecond(2);
        Assert.assertTrue("No se elimino el item", centerSection.deleteVerification.controlIsDisplayed());
        //deleteProject
        leftSection.currentProject.click();
        leftSection.scroll.click();
        leftSection.deleteButton.click();
        Session.getSession().getDriver().switchTo().alert().accept();
        this.waitOnSecond(2);
        Assert.assertNotEquals("No se borro", name, centerSection.projectNameLabel.getText());
    }
}
