package clean.calculadora;

import activities.calculadora.MainScreen;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import session.Session;

import java.net.MalformedURLException;

public class CalculadoraTest {
    MainScreen mainScreen = new MainScreen();

    @Test
    public void verifySuma() throws MalformedURLException, InterruptedException {
        mainScreen.twoButton.click();
        mainScreen.plusButton.click();
        mainScreen.sevenButton.click();
        mainScreen.equalsButton.click();

        Thread.sleep(2000);
        String expected = "9";
        String actual1 = mainScreen.results.getText();
        String[] actual2 = actual1.split("=");
        String[] actual3 = actual2[1].split("\\.");
        String actual = actual3[0];
        Assert.assertEquals("Mal", expected, actual);
    }

    @After
    public void closeApp() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
