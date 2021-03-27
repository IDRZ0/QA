package basic;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalculadoraTest {
    private AppiumDriver driver;

    @Before
    public void before() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "A5");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity", ".Calculator");
        capabilities.setCapability("platformName", "Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void verifySuma() throws InterruptedException {
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_02")).click();
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_07")).click();
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();

        Thread.sleep(2000);
        String expected = "9";

        String actual1 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();
        String[] actual2 = actual1.split("=");
        String[] actual3 = actual2[1].split("\\.");
        String actual = actual3[0];
        Assert.assertEquals("Mal", expected, actual);
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
