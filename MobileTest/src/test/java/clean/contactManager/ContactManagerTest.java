package clean.contactManager;

import activities.contactManager.AddContactScreen;
import activities.contactManager.MainScreen;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import session.Session;

import java.net.MalformedURLException;

public class ContactManagerTest {
    MainScreen mainScreen = new MainScreen();
    AddContactScreen addContactScreen = new AddContactScreen();

    String name = "AaaRemove";
    String phone = "1111111";
    String email = "remove@remove.com";

    @Test
    public void verifyCreate() throws MalformedURLException, InterruptedException {
        mainScreen.addContactButton.click();
        addContactScreen.spinner.click();
        addContactScreen.whatsapp.click();
        addContactScreen.name.set(name);
        addContactScreen.phone.set(phone);
        addContactScreen.email.set(email);
        addContactScreen.save.click();

        Thread.sleep(2000);
        mainScreen.showInvisible.click();

        Thread.sleep(2000);
        Assert.assertTrue("Mal", mainScreen.contactName.isControlDisplayed());
    }

    @After
    public void closeApp() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
