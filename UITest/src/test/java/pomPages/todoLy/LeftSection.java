package pomPages.todoLy;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class LeftSection {
    public Button addNewProjectButton = new Button(By.xpath("//td[contains(.,'Add New Project') and @class='ProjItemContent']"));
    public Button addButton = new Button(By.xpath("//input[@id='NewProjNameButton']"));
    public TextBox nameProjectTextBox = new TextBox(By.xpath("//input[@id='NewProjNameInput']"));

    public Button currentProject = new Button(By.xpath("//li[last()]//td[@class='ProjItemContent']"));
    public Button scroll = new Button(By.xpath("//div[@style='display: block;']/img[@src='/Images/dropdown.png']"));
    public Button editButton = new Button(By.xpath("//ul[@id='projectContextMenu']//a[contains(.,'Edit')]"));
    public TextBox editProjectName = new TextBox(By.id("ItemEditTextbox"));
    public Button saveButton = new Button(By.xpath("//li//div[@id='ProjectEditDiv']/*[@id=\"ItemEditSubmit\"]"));

    public Button deleteButton = new Button(By.xpath("//ul[@id='projectContextMenu']//a[contains(.,'Delete')]"));

    public Button recyclerButton = new Button(By.xpath("//tr//td[@class='FilterItemContent' and contains(.,'Recycle')]"));
    public Button emptyButton = new Button(By.xpath("//a[contains(.,'Empty')]"));

    public LeftSection() {
    }
}
