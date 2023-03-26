package org.example;

public class ItemCarrito {
    private int cantidad;
    private double precio;
    private Producto producto;

    ItemCarrito(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return producto.getPrecio() * cantidad;
    }


}
