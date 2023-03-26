package org.example;

public class ItemCarrito {
    private int cantidad;
    private int precio;
    private String producto;

    ItemCarrito(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.precio = producto.getPrecio();
        this.producto = producto.getNombre();
    }
}
