package calculadoraTest;

import calculadora.Calculadora;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SumaTest {
    Calculadora c;

    @Before
    public void calculadora() {
        c = new Calculadora();
    }

    @Test
    public void sumaPares() {
        int actual = c.suma(4, 4);
        int expected = 8;
        Assert.assertEquals("Fallo loco", actual, expected);
    }

    @Test
    public void sumaImpares() {
        int actual = c.suma(5, 5);
        int expected = 10;
        Assert.assertEquals("Fallo loco", actual, expected);
    }

    @Test
    public void sumaAmbos() {
        int actual = c.suma(4, 5);
        int expected = 9;
        Assert.assertEquals("Fallo loco", actual, expected);
    }
}