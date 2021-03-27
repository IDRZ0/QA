package calculadoraTestSuite;

import calculadoraTest.DivTest;
import calculadoraTest.ProdTest;
import calculadoraTest.RestaTest;
import calculadoraTest.SumaTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(
        {
                DivTest.class,
                ProdTest.class,
                RestaTest.class,
                SumaTest.class
        }
)

public class CalculadoraTestSuite {
}
