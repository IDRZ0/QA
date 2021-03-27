package pomPages.todoLy;

import controls.Button;
import controls.Label;
import controls.TextBox;
import org.openqa.selenium.By;

public class CenterSection {
    public Label projectNameLabel = new Label(By.xpath("//div[@id='CurrentProjectTitle']"));
    public TextBox itemTextBox = new TextBox(By.xpath("//textarea[@id='NewItemContentInput']"));
    public Button addItemButton = new Button(By.xpath("//input[@id='NewItemAddButton']"));
    public TextBox editItemName = new TextBox(By.xpath("//div[@class='ItemContentDiv' and @style]"));
    public TextBox editItemNameClicked = new TextBox(By.xpath("//textarea[@id='ItemEditTextbox' and @style]"));
    public Button scroll = new Button(By.xpath("//img[@style='display: inline;' and @src='/Images/dropdown.png']"));
    public Button editItem = new Button(By.xpath("//ul[@id='itemContextMenu']//a[@href='#edit']"));
    public Button deleteItem = new Button(By.xpath("//ul[@id='itemContextMenu']//a[@href='#delete']"));
    public Label deleteVerification = new Label(By.xpath("//span[@id='InfoMessageText']"));

    public Label emptyVerification = new Label(By.xpath("//span[contains(.,'Recycle')]"));

    public CenterSection() {
    }
}
