package pomPages.todoist;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class LoginPage2 {
    public TextBox nameBox = new TextBox(By.xpath("//input[@id='full_name']"));
    public TextBox pwdBox = new TextBox(By.xpath("//input[@id='pwd']"));
    public Button registerButton2 = new Button(By.xpath("//button[@id='step_two_submit']"));

    public LoginPage2() {
    }
}
