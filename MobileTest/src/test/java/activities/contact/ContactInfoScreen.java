package activities.contact;

import control.Button;
import org.openqa.selenium.By;

public class ContactInfoScreen {
    public Button exitButton = new Button(By.xpath("//android.widget.ImageButton[@content-desc='Navegar hacia arriba']"));

    public ContactInfoScreen() {
    }
}
