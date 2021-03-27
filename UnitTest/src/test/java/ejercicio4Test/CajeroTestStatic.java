package ejercicio4Test;

import ejercicio4.ej4static.BDUtil2;
import ejercicio4.ej4static.Cajero2;
import ejercicio4.ej4static.ClienteDB2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Parameterized.class)
@PrepareForTest({BDUtil2.class, ClienteDB2.class})
public class CajeroTestStatic {
    @Parameterized.Parameter(0)
    public int ci;
    @Parameterized.Parameter(1)
    public int saldo;
    @Parameterized.Parameter(2)
    public int amount;
    @Parameterized.Parameter(3)
    public boolean isConnected;
    @Parameterized.Parameter(4)
    public boolean isUpdated;
    @Parameterized.Parameter(5)
    public String expectedResult;

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

    @Test
    public void verify_calculate_saldo() {
        PowerMockito.mockStatic(BDUtil2.class);
        PowerMockito.mockStatic(ClienteDB2.class);

        Mockito.when(ClienteDB2.isConnectionSuccessfully("mysql")).thenReturn(this.isConnected);
        Mockito.when(BDUtil2.updateSaldo(this.ci, this.saldo - this.amount)).thenReturn(this.isUpdated);

        Cajero2 cajero = new Cajero2(this.saldo);
        String actualResult = cajero.getCash(this.ci, this.amount);
        Assert.assertEquals("Mal", this.expectedResult, actualResult);
    }
}
