package devices;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public interface IDevice {
    AppiumDriver crear() throws MalformedURLException;
}
