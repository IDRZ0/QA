package pomPages.todoLy;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class SettingsPage {
    public TextBox oldPass = new TextBox(By.xpath("//input[@id='TextPwOld']"));
    public TextBox newPass = new TextBox(By.xpath("//input[@id='TextPwNew']"));
    public Button save = new Button(By.xpath("//span[@class='ui-button-text' and contains(.,'Ok')]"));

    public SettingsPage() {
    }
}
