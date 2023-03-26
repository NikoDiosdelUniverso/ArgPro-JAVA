import org.example.Carrito;
import org.example.DescuentoFijo;
import org.example.exceptions.DescuentoMayorQuePrecioException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CarritoTest {

    @Test
    public void testPrecio1() throws DescuentoMayorQuePrecioException {
    Carrito carrito = new Carrito();
    assertEquals(0, carrito.getPrecio(new DescuentoFijo(0)), 0);
    }

    @Test
    public void testPrecio2() {
        Carrito carrito = new Carrito();
        assertThrows(DescuentoMayorQuePrecioException.class, () -> carrito.getPrecio(new DescuentoFijo(10)));
    }
}
