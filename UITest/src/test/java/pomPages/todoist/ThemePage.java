package pomPages.todoist;

import controls.Button;
import org.openqa.selenium.By;

public class ThemePage {
    public Button open = new Button(By.xpath("//a[@class='tdo-button js-cta js-cta-finish']"));

    public ThemePage() {
    }
}
