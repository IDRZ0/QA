package examen1.examen1TestSuite;

import examen1.ej1test.Ej1Test;
import examen1.ej2test.Ej2Test;
import examen1.ej3test.Ej3Test;
import examen1.ej4test.Ej4Test;
import examen1.ej5test.Ej5Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(
        {
                Ej1Test.class,
                Ej2Test.class,
                Ej3Test.class,
                Ej4Test.class,
                Ej5Test.class
        }
)
public class Examen1TestSuite {
}
