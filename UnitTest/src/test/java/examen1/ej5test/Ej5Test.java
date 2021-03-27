package examen1.ej5test;

import examen1.p5.Ej5;
import examen1.p5.Util;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Util.class)
public class Ej5Test {
    @Test
    public void verify_cambio_moneda() {
        PowerMockito.mockStatic(Util.class);

        Mockito.when(Util.obtenerTipoDeCambio("Dolares", "Bolivianos")).thenReturn(7);

        Ej5 ej5 = new Ej5();
        String actualResult = ej5.saveInNewMoney(100, "Dolares", "Bolivianos");
        String expectedResult = "La cantidad convertida fue : [700] Bolivianos";
        Assert.assertEquals("Mal", expectedResult, actualResult);
    }
}
