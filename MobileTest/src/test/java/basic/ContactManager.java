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

public class ContactManager {
    private AppiumDriver driver;
    String name = "A";
    String phone = "1111111";
    String email = "remove@remove.com";

    @Before
    public void before() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "A5");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
        capabilities.setCapability("platformName", "Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void verifyCreate() throws InterruptedException {
        driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();
        driver.findElement(By.id("com.example.android.contactmanager:id/accountSpinner")).click();
        driver.findElement(By.xpath("//android.widget.RelativeLayout//android.widget.TextView[@text='WhatsApp' and @resource-id='com.example.android.contactmanager:id/firstAccountLine']")).click();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys(name);
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys(phone);
        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).sendKeys(email);
        driver.findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).click();

        Thread.sleep(2000);
        driver.findElement(By.id("com.example.android.contactmanager:id/showInvisible")).click();

        Thread.sleep(2000);
        Assert.assertTrue("Mal", driver.findElement(By.xpath("//android.widget.TextView[@text='" + name + "']")).isDisplayed());
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    // add: com.example.android.contactmanager:id/addContactButton
    // spinner: com.example.android.contactmanager:id/accountSpinner
    // whatsapp: //android.widget.RelativeLayout//android.widget.TextView[@text='WhatsApp' and @resource-id='com.example.android.contactmanager:id/firstAccountLine']
    // name: com.example.android.contactmanager:id/contactNameEditText
    // phone: com.example.android.contactmanager:id/contactPhoneEditText
    // email: com.example.android.contactmanager:id/contactEmailEditText
    // save: com.example.android.contactmanager:id/contactSaveButton
    //
}
