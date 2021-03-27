package pomPages.todoist;

import controls.Button;
import controls.Image;
import controls.Label;
import org.openqa.selenium.By;

public class MainPage {
    public Image profileImage = new Image(By.xpath("//img[@class='user_avatar big settings_avatar']"));
    public Label username = new Label(By.xpath("//strong"));
    public Button settingButton = new Button(By.xpath("//button[@id='user_menu_settings_menuitem']"));
    public Button logoutButton = new Button(By.xpath("//button[@role='menuitem']//span[contains(.,'Cerrar')]"));

    public MainPage() {
    }
}
