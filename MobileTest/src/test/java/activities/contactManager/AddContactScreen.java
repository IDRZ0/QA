package activities.contactManager;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class AddContactScreen {
    public Button spinner = new Button(By.id("com.example.android.contactmanager:id/accountSpinner"));
    public Button whatsapp = new Button(By.xpath("//android.widget.RelativeLayout//android.widget.TextView[@text='WhatsApp' and @resource-id='com.example.android.contactmanager:id/firstAccountLine']"));
    public TextBox name = new TextBox(By.id("com.example.android.contactmanager:id/contactNameEditText"));
    public TextBox phone = new TextBox(By.id("com.example.android.contactmanager:id/contactPhoneEditText"));
    public TextBox email = new TextBox(By.id("com.example.android.contactmanager:id/contactEmailEditText"));
    public Button save = new Button(By.id("com.example.android.contactmanager:id/contactSaveButton"));

    public AddContactScreen() {
    }
}
