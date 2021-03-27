package activities.alarma;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class AlarmPage {
    public Button createAlarm = new Button(By.id("com.sec.android.app.clockpackage:id/custom_create_button_alarm"));
    public Label time = new Label(By.id("com.sec.android.app.clockpackage:id/alarm_item_time"));

    public AlarmPage() {
    }
}
