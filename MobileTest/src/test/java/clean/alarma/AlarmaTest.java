package clean.alarma;

import activities.alarma.AlarmPage;
import activities.alarma.CreateAlarmPage;
import clean.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class AlarmaTest extends TestBase {
    AlarmPage alarmPage = new AlarmPage();
    CreateAlarmPage createAlarmPage = new CreateAlarmPage();

    @Test
    public void verify_alarm() throws MalformedURLException, InterruptedException {
        alarmPage.createAlarm.click();

        createAlarmPage.done.click();

        Thread.sleep(2000);
        Assert.assertTrue("Mal", alarmPage.time.isControlDisplayed());
    }
}
