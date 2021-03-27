package calculadoraTest;

import calculadora.Calculadora;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivTest {
    Calculadora c;

    @Before
    public void calculadora() {
        c = new Calculadora();
    }

    @Test
    public void divPares() {
        int actual = c.div(8, 4);
        int expected = 2;
        Assert.assertEquals("Fallo loco", actual, expected);
    }

    @Test
    public void divImpares() {
        int actual = c.div(15, 5);
        int expected = 3;
        Assert.assertEquals("Fallo loco", actual, expected);
    }

    @Test(expected = ArithmeticException.class)
    public void divAmbos() {
        c.div(7, 0);
    }
}
