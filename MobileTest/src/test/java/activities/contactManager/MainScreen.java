package activities.contactManager;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class MainScreen {
    public Button addContactButton = new Button(By.id("com.example.android.contactmanager:id/addContactButton"));
    public Button showInvisible = new Button(By.id("com.example.android.contactmanager:id/showInvisible"));
    public Label contactName = new Label(By.xpath("//android.widget.TextView[@text='AaaRemove']"));

    public MainScreen() {
    }
}
