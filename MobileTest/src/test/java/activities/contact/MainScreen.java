package activities.contact;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class MainScreen {
    public Button addContactButton = new Button(By.id("com.android.contacts:id/first_option_menu"));
    public Label contactName = new Label(By.xpath("//android.widget.TextView[@text='AaaRemove' and @resource-id]"));

    public MainScreen() {
    }
}
