package pomPages.todoist;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class LoginPage1 {
    public TextBox emailBox= new TextBox(By.xpath("//input[@class='input_email']"));
    public Button registerButton = new Button(By.xpath("//button[@id='step_one_submit']"));

    public LoginPage1() {
    }
}
