import org.example.Calculadora;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CalculadoraTest {

    Calculadora calculadora;

    @Before
    public void antes(){
        calculadora = new Calculadora();
    }

    @Test
    public void testMultiplicar() {
    double suma = calculadora.multiplicar(80, 3);
    assertEquals(240, suma, 0);
    }

    @Test
    public void testSumaYDivision() {
        double resultado = calculadora.dividir( calculadora.sumar(150,180),3);
        assertEquals(110, resultado, 0);
    }

    @Test
    public void testRestaYMultiplicacion() {
        double resultado = calculadora.multiplicar(calculadora.restar(90, 50), 15 );
        assertNotEquals(605, resultado, 0);
    }

    @Test
    public void testSumaYMultiplicacion() {
        double resultado = calculadora.multiplicar(calculadora.sumar(70, 40), 25);
        assertNotEquals(2700, resultado, 0);
    }
}
