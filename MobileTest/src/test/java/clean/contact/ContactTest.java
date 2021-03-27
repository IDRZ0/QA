package clean.contact;

import activities.contact.AddContactScreen;
import activities.contact.ContactInfoScreen;
import activities.contact.DialogScreen;
import activities.contact.MainScreen;
import clean.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class ContactTest extends TestBase {
    MainScreen mainScreen = new MainScreen();
    AddContactScreen addContactScreen = new AddContactScreen();
    ContactInfoScreen contactInfoScreen = new ContactInfoScreen();
    DialogScreen dialogScreen = new DialogScreen();

    String name = "AaaRemove";
    String phone = "11111111";

    @Test
    public void verifyCreate() throws MalformedURLException, InterruptedException {
        mainScreen.addContactButton.click();

        Thread.sleep(500);
        dialogScreen.permitir.click();
        Thread.sleep(500);
        dialogScreen.dispositivo.click();
        Thread.sleep(500);
        dialogScreen.aceptar.click();
        Thread.sleep(500);

        addContactScreen.nameTextBox.set(name);
        addContactScreen.phoneTextBox.set(phone);
        addContactScreen.saveContactButton.click();

        contactInfoScreen.exitButton.click();

        Thread.sleep(2000);
        String expected = name;
        String actual = mainScreen.contactName.getText();
        Assert.assertEquals("Mal", expected, actual);
    }
}
