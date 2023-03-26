package org.example;

import org.example.exceptions.DescuentoMayorQuePrecioException;
import org.example.exceptions.DescuentoSuperaTopeException;

public abstract class Descuento {
    private float valor;
    public float getValorDesc() {
        return valor;
    }
    public void setValorDesc(float valor) {
        this.valor = valor;
    }
    public abstract float valorFinal(float valorInicial) throws DescuentoMayorQuePrecioException, DescuentoSuperaTopeException;
}
