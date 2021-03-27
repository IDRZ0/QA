package pomPages.todoist;

import controls.Button;
import org.openqa.selenium.By;

public class StartPage {
    public Button getStarted = new Button(By.xpath("//div[@class='_3BBq0']//a[@href='/users/showregister']"));

    public StartPage() {
    }
}
