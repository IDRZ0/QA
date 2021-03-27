package examen1.ej2test;

import examen1.p2.Ej2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class Ej2Test {
    private int nota;
    private String expectedResult;

    public Ej2Test(int nota, String expectedResult) {
        this.nota = nota;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        List<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{-1, "VALOR INCORRECTO"});
        objects.add(new Object[]{0, "F"}); //falla, no acpeta 0 como nota
        objects.add(new Object[]{1, "F"});
        objects.add(new Object[]{4, "F"});
        objects.add(new Object[]{5, "F"});
        objects.add(new Object[]{6, "C"});
        objects.add(new Object[]{9, "B"});
        objects.add(new Object[]{10, "A"});
        objects.add(new Object[]{11, "VALOR INCORRECTO"});

        return objects;
    }

    @Test
    public void veryfy_nota() {
        Ej2 ej2 = new Ej2();
        String actualResult = ej2.notasCualitativas(this.nota);
        Assert.assertEquals("Mal", this.expectedResult, actualResult);
    }
}
