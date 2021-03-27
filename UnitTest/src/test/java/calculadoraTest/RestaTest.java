package calculadoraTest;

import calculadora.Calculadora;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RestaTest {
    Calculadora c;

    @Before
    public void calculadora() {
        c = new Calculadora();
    }

    @Test
    public void restaPares() {
        int actual = c.resta(8, 4);
        int expected = 4;
        Assert.assertEquals("Fallo loco", actual, expected);
    }

    @Test
    public void restaImpares() {
        int actual = c.resta(9, 5);
        int expected = 4;
        Assert.assertEquals("Fallo loco", actual, expected);
    }

    @Test
    public void restaAmbos() {
        int actual = c.resta(7, 2);
        int expected = 5;
        Assert.assertEquals("Fallo loco", actual, expected);
    }
}
