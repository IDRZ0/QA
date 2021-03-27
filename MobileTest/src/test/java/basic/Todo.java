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

public class Todo {
    private AppiumDriver driver;
    String title = "Ignacio";
    String notes = "Prueba";

    @Before
    public void before() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "A5");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("appPackage", "com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity", ".ui.HomeActivity");
        capabilities.setCapability("platformName", "Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void verifyCreate() throws InterruptedException {
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(title);
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(notes);
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();

        Thread.sleep(2000);
        Assert.assertEquals("Mal", driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text")).getText(), title);
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    // add: com.vrproductiveapps.whendo:id/fab
    // title: com.vrproductiveapps.whendo:id/noteTextTitle
    // notes: com.vrproductiveapps.whendo:id/noteTextNotes
    // save: com.vrproductiveapps.whendo:id/saveItem
    // ti: com.vrproductiveapps.whendo:id/home_list_item_text
}
