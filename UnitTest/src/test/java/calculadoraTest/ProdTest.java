package calculadoraTest;

import calculadora.Calculadora;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProdTest {
    Calculadora c;

    @Before
    public void calculadora() {
        c = new Calculadora();
    }

    @Test
    public void prodPares() {
        int actual = c.prod(4, 4);
        int expected = 16;
        Assert.assertEquals("Fallo loco", actual, expected);
    }

    @Test
    public void prodImpares() {
        int actual = c.prod(3, 3);
        int expected = 9;
        Assert.assertEquals("Fallo loco", actual, expected);
    }

    @Test
    public void prodAmbos() {
        int actual = c.prod(7, 2);
        int expected = 14;
        Assert.assertEquals("Fallo loco", actual, expected);
    }
}
