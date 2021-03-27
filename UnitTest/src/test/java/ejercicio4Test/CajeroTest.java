package ejercicio4Test;

import ejercicio4.ej4.BDUtil;
import ejercicio4.ej4.Cajero;
import ejercicio4.ej4.ClienteDB;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class CajeroTest {
    int ci;
    int saldo;
    int amount;
    boolean isConnected;
    boolean isUpdated;
    String expectedResult;

    public CajeroTest(int ci, int saldo, int amount, boolean isConnected, boolean isUpdated, String expectedResult) {
        this.ci = ci;
        this.saldo = saldo;
        this.amount = amount;
        this.isConnected = isConnected;
        this.isUpdated = isUpdated;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        List<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{1000000, 1, 1, false, true, "Conexion a BD no fue satisfactoria"});
        objects.add(new Object[]{1000000, 1, 1, true, false, "Actualizacion Incorrecta, Intente Nuevamente"});
        objects.add(new Object[]{1000000, 1, 0, true, true, "Amount No Valido"});
        objects.add(new Object[]{1000000, 10, 100, true, true, "Usted no tiene suficiente saldo"});
        objects.add(new Object[]{1000000, 10, 100, false, true, "Conexion a BD no fue satisfactoria"});
        objects.add(new Object[]{1000000, 10, 100, true, false, "Usted no tiene suficiente saldo"});
        objects.add(new Object[]{1000000, 100, 100, false, true, "Conexion a BD no fue satisfactoria"});
        objects.add(new Object[]{1000000, 100, 0, true, true, "Amount No Valido"});
        objects.add(new Object[]{1000000, 100, 1, true, true, "Usted esta sacando la cantidad de 1 y tiene en saldo 99"});
        objects.add(new Object[]{1000000, 100, 2, true, true, "Usted esta sacando la cantidad de 2 y tiene en saldo 98"});
        objects.add(new Object[]{1000000, 100, 49, true, true, "Usted esta sacando la cantidad de 49 y tiene en saldo 51"});
        objects.add(new Object[]{1000000, 100, 50, true, true, "Usted esta sacando la cantidad de 50 y tiene en saldo 50"});
        objects.add(new Object[]{1000000, 100, 51, true, true, "Usted esta sacando la cantidad de 51 y tiene en saldo 49"});
        objects.add(new Object[]{1000000, 100, 99, true, true, "Usted esta sacando la cantidad de 99 y tiene en saldo 1"});
        objects.add(new Object[]{1000000, 100, 100, true, true, "Usted esta sacando la cantidad de 100 y tiene en saldo 0"});
        objects.add(new Object[]{1000000, 100, 101, true, true, "Usted no tiene suficiente saldo"});
        objects.add(new Object[]{1000000, 100, 100, true, false, "Actualizacion Incorrecta, Intente Nuevamente"});

        //no verifica si el saldo que se le pasa es positivo o negativo
        objects.add(new Object[]{1000000, -1, 1, true, true, "No se puede tener un saldo negativo"});
        //no verifica el numero del ci, acepta cualquier numero
        objects.add(new Object[]{-1, -1, -1, false, false, "Conexion a BD no fue satisfactoria"});

        return objects;
    }

    BDUtil utilMock = Mockito.mock(BDUtil.class);
    ClienteDB clienteMock = Mockito.mock(ClienteDB.class);

    @Test
    public void verify_calculate_saldo() {
        Mockito.when(clienteMock.isConnectionSuccessfully("mysql")).thenReturn(this.isConnected);
        Mockito.when(utilMock.updateSaldo(this.ci, this.saldo - this.amount)).thenReturn(this.isUpdated);

        Cajero cajero = new Cajero(this.saldo, utilMock, clienteMock);
        String actualResult = cajero.getCash(this.ci, this.amount);
        Assert.assertEquals("Mal", this.expectedResult, actualResult);
    }
}
