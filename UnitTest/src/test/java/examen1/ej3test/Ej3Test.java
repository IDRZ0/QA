package examen1.ej3test;

import examen1.p3.Ej3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Ej3Test {
    Ej3 ej3;

    @Before
    public void iniciar() {
        ej3 = new Ej3();
    }

    @Test(expected = Exception.class)
    public void emptyValue() throws Exception {
        boolean actualResult = ej3.isCorrectCI("");
        boolean expectedResult = false;
        Assert.assertEquals("Mal", expectedResult, actualResult);
    }

    @Test(expected = Exception.class)
    public void ceroValue() throws Exception {
        boolean actualResult = ej3.isCorrectCI("0");
        boolean expectedResult = false;
        Assert.assertEquals("Mal", expectedResult, actualResult);
    }

    @Test(timeout = 2000)
    public void correctValue() throws Exception {
        boolean actualResult = ej3.isCorrectCI("1");
        boolean expectedResult = true;
        Assert.assertEquals("Mal", expectedResult, actualResult);
    }
}
