package clean;

import org.junit.After;
import session.Session;

import java.net.MalformedURLException;

public class TestBase {
    @After
    public void closeApp() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
