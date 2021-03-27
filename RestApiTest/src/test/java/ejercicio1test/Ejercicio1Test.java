package ejercicio1test;

import ejercicio1.Ejercicio1;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Ejercicio1Test {
    JSONObject actualJson;
    JSONObject expectedJson;

    @Before
    public void json() {
        actualJson = new JSONObject();
        expectedJson = new JSONObject();
    }

    @Test
    public void testEquals() {
        actualJson.put("Nombre", "Juan");
        actualJson.put("Apellido", "Perez");
        actualJson.put("Edad", 10);
        expectedJson.put("Nombre", "Juan");
        expectedJson.put("Apellido", "Perez");
        expectedJson.put("Edad", 10);

        boolean expectedResult = true;
        boolean actualResult = Ejercicio1.compareJson(actualJson.toString(), expectedJson.toString());
        Assert.assertEquals("Mal", expectedResult, actualResult);
    }

    @Test
    public void testNotEquals() {
        actualJson.put("Nombre", "Juan");
        actualJson.put("Apellido", "Perez");
        actualJson.put("Edad", 10);
        expectedJson.put("Nombre", "Juan");
        expectedJson.put("Apellido", "Perez");
        expectedJson.put("Edad", 11);

        boolean expectedResult = false;
        boolean actualResult = Ejercicio1.compareJson(actualJson.toString(), expectedJson.toString());
        Assert.assertEquals("Mal", expectedResult, actualResult);
    }

    @Test
    public void testIgnoreGood() {
        actualJson.put("Nombre", "Juan");
        actualJson.put("Apellido", "Perez");
        actualJson.put("Edad", 10);
        expectedJson.put("Nombre", "Juan");
        expectedJson.put("Apellido", "IGNORE");
        expectedJson.put("Edad", 10);

        boolean expectedResult = true;
        boolean actualResult = Ejercicio1.compareJson(actualJson.toString(), expectedJson.toString());
        Assert.assertEquals("Mal", expectedResult, actualResult);
    }

    @Test
    public void testIgnoreBad() {
        actualJson.put("Nombre", "Juan");
        actualJson.put("Apellido", "Perez");
        actualJson.put("Edad", 10);
        expectedJson.put("Nombre", "Juan");
        expectedJson.put("Apellido", "IGNORE");
        expectedJson.put("Edad", 11);

        boolean expectedResult = false;
        boolean actualResult = Ejercicio1.compareJson(actualJson.toString(), expectedJson.toString());
        Assert.assertEquals("Mal", expectedResult, actualResult);
    }
}
