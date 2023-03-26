package org.example;

import org.example.exceptions.DescuentoMayorQuePrecioException;
import org.example.exceptions.DescuentoSuperaTopeException;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<ItemCarrito> items = new ArrayList<>();

    public void addItem(ItemCarrito item) {
        items.add(item);
    }

    public double getPrecio(Descuento descuento) throws DescuentoMayorQuePrecioException {
        double subtotal = 0;

        for (ItemCarrito item : items) {
            subtotal += item.getPrecio();
        }
        try {
            return descuento.valorFinal((float) subtotal);
        } catch (DescuentoMayorQuePrecioException e) {
            System.out.println("El descuento no puede ser mayor que el precio!");
        } catch (DescuentoSuperaTopeException e) {
            System.out.println("El descuento no puede ser mayor al 50%!");
        }
        return subtotal;
    }
}
