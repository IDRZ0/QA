package examen1.ej4test;

import examen1.p4.Ej4;
import examen1.p4.Util;
import examen1.p4.Util2;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class Ej4Test {
    Util utilMock = Mockito.mock(Util.class);
    Util2 util2Mock = Mockito.mock(Util2.class);

    String name = "ignacio";
    String password = "password";

    @Test
    public void verify_permisos() {
        Mockito.when(util2Mock.isUserValid(name, password)).thenReturn(true);
        Mockito.when(utilMock.getPermision(name, password)).thenReturn(": CRUD");

        Ej4 ej4 = new Ej4(utilMock, util2Mock);

        String expectedResult = ej4.roleUser(name, password);
        String actualResult = "PERMISSION ROLE : CRUD";
        Assert.assertEquals("Mal", expectedResult, actualResult);
    }
}
