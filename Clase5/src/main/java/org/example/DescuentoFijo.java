package org.example;

import org.example.exceptions.DescuentoMayorQuePrecioException;

public class DescuentoFijo extends Descuento{

    public DescuentoFijo(float valor) {
        this.setValorDesc(valor);
    }
    @Override
    public float valorFinal(float valorInicial) throws DescuentoMayorQuePrecioException {
        if (this.getValorDesc() > valorInicial) {
            throw new DescuentoMayorQuePrecioException();
        }
        return valorInicial - this.getValorDesc();
    }
}
