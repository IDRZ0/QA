package activities.calculadora;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class MainScreen {
    public Button twoButton = new Button(By.id("com.sec.android.app.popupcalculator:id/bt_02"));
    public Button sevenButton = new Button(By.id("com.sec.android.app.popupcalculator:id/bt_07"));
    public Button plusButton = new Button(By.id("com.sec.android.app.popupcalculator:id/bt_add"));
    public Button equalsButton = new Button(By.id("com.sec.android.app.popupcalculator:id/bt_equal"));
    public Label results = new Label(By.id("com.sec.android.app.popupcalculator:id/txtCalc"));

    public MainScreen() {
    }
}
