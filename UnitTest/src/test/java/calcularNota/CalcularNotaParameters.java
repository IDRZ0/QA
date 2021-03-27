package calcularNota;

import ejercicio1.CalcularNota;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class CalcularNotaParameters {
    private int nota1;
    private int nota2;
    private int nota3;
    private String expectedResult;

    public CalcularNotaParameters(int nota1, int nota2, int nota3, String expectedResult) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        List<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{0, 0, 0, "Esfuerzate mas, su nota es : 0"});
        objects.add(new Object[]{100, 100, 100, "Excelente su nota es : 100"});
        objects.add(new Object[]{101, 80, 80, "*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{99, 80, 80, "Muy Bien su nota es : 86"});
        objects.add(new Object[]{1, 80, 80, "Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{-1, 80, 80, "*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{49, 80, 80, "Esfuerzate mas, su nota es : 69"});
        objects.add(new Object[]{50, 80, 80, "Esfuerzate mas, su nota es : 70"});
        objects.add(new Object[]{51, 80, 80, "Esfuerzate mas, su nota es : 70"});

        objects.add(new Object[]{80, 0, 80, "Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80, 100, 80, "Muy Bien su nota es : 86"});
        objects.add(new Object[]{80, 101, 80, "*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80, 99, 80, "Muy Bien su nota es : 86"});
        objects.add(new Object[]{80, 1, 80, "Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80, -1, 80, "*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80, 49, 80, "Esfuerzate mas, su nota es : 69"});
        objects.add(new Object[]{80, 50, 80, "Esfuerzate mas, su nota es : 70"});
        objects.add(new Object[]{80, 51, 80, "Esfuerzate mas, su nota es : 70"});

        objects.add(new Object[]{80, 80, 0, "Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80, 80, 100, "Muy Bien su nota es : 86"});
        objects.add(new Object[]{80, 80, 101, "*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80, 80, 99, "Muy Bien su nota es : 86"});
        objects.add(new Object[]{80, 80, 1, "Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80, 80, -1, "*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80, 80, 49, "Esfuerzate mas, su nota es : 69"});
        objects.add(new Object[]{80, 80, 50, "Esfuerzate mas, su nota es : 70"});
        objects.add(new Object[]{80, 80, 51, "Esfuerzate mas, su nota es : 70"});

        return objects;
    }


    @Test
    public void verify_suma_all_values() {
        CalcularNota calculaNota = new CalcularNota();
        String actualResult = calculaNota.notaFinal(this.nota1, this.nota2, this.nota3);
        Assert.assertEquals("Mal", this.expectedResult, actualResult);
    }
}
