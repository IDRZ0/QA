package examen1.ej1test;

import examen1.p1.Ej1;
import org.junit.*;

public class Ej1Test {
    Ej1 ej1;

    @BeforeClass
    public static void iniciar() {
        System.out.println("Iniciando las pruebas");
    }

    @Before
    public void setEj1() {
        ej1 = new Ej1();
    }

    @After
    public void after() {
        System.out.println("Test finalizado");
    }

    @AfterClass
    public static void finish() {
        System.out.println("Todos los test finalizados");
    }

    @Test
    public void primoCero() {
        boolean actualResult = ej1.esPrimo(0);
        boolean expectedResult = false;
        Assert.assertEquals("Error", expectedResult, actualResult);
    }

    @Test
    public void primoFalse() {
        boolean actualResult = ej1.esPrimo(4);
        boolean expectedResult = false;
        Assert.assertEquals("Error", expectedResult, actualResult);
    }

    @Test
    public void primoVerdadero() {
        boolean actualResult = ej1.esPrimo(3);
        boolean expectedResult = true;
        Assert.assertEquals("Error", expectedResult, actualResult);
    }
}
