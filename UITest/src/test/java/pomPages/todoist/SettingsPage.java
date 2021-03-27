package pomPages.todoist;

import controls.Button;
import controls.Label;
import controls.TextBox;
import org.openqa.selenium.By;

public class SettingsPage {
    public Label username = new Label(By.xpath("//dd[@class]//span[@class='data']"));
    public Button editName = new Button(By.xpath("//dd[@class]//a[@class='inline_edit_link']"));
    public TextBox nameBox = new TextBox(By.xpath("//form//input[@type='text']"));
    public Button save = new Button(By.xpath("//form//a[contains(.,'Guardar')]"));

    public SettingsPage() {
    }
}
