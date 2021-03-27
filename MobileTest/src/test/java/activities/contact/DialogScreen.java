package activities.contact;

import control.Button;
import org.openqa.selenium.By;

public class DialogScreen {
    public Button permitir = new Button(By.id("com.android.packageinstaller:id/permission_allow_button"));
    public Button dispositivo = new Button(By.xpath("//android.widget.TextView[@text='Dispositivo']"));
    public Button aceptar = new Button(By.id("android:id/button1"));

    public DialogScreen() {
    }
}
