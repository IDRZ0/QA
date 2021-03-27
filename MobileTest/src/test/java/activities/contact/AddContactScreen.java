package activities.contact;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class AddContactScreen {
    public TextBox nameTextBox = new TextBox(By.xpath("//android.widget.EditText[@text='Nombre']"));
    public TextBox phoneTextBox = new TextBox(By.xpath("//android.widget.EditText[contains(@text,'mero')]"));
    public Button saveContactButton = new Button(By.id("com.android.contacts:id/menu_done"));

    public AddContactScreen() {
    }

}
