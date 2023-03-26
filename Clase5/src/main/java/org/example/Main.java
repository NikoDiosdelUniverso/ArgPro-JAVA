package org.example;

import org.example.exceptions.DescuentoMayorQuePrecioException;
import org.example.exceptions.DescuentoSuperaTopeException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    // Lee los datos del archivo, separados por comas, y agrega los items al carrito
    private static Carrito agregarAlCarrito(String ruta) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(ruta));
        Carrito carrito = new Carrito();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            int cantidad = Integer.parseInt(parts[0]);
            double precio = Double.parseDouble(parts[1]);
            String nombre = parts[2];
            Producto producto = new Producto(nombre, precio);
            carrito.addItem(new ItemCarrito(cantidad, producto));
        }
        reader.close();
        return carrito;
    }

    private static Descuento descuentos(String tipo, float valor) {
        Descuento desc = null;
        if (tipo.equals("f")) {
            desc = new DescuentoFijo(valor);
        } else if (tipo.equals("p")) {
            desc = new DescuentoPorcentaje(valor);
        } else if (tipo.equals("t")) {
                desc = new DescuentoPorcentajeConTope(valor);
        } else {
            desc = new DescuentoFijo(0);
        }
        return desc;
    }

    public static void main(String[] args) throws IOException, DescuentoMayorQuePrecioException {
        String ruta = "src/main/resources/listaDeItems.csv";
        //descomentar la siguiente linea para introducir la ruta del archivo como tercer argumento
        //String ruta = args[2];
        // El primer argumento debe ser "f" (descuento fijo), "p" (descuento porcentaje) o "t" (porcentaje fijo con tope)
        String tipoDescuento = args[0];
        // El segundo argumento debe ser el valor del descuento
        float valorDescuento = Float.parseFloat(args[1]);

        //imprime el valor total del carrito, con descuento aplicado
        System.out.println("El total es: " + agregarAlCarrito(ruta).getPrecio(descuentos(tipoDescuento, valorDescuento)));
    }
}