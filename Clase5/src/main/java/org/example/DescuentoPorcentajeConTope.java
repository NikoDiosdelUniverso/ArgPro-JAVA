package org.example;

import org.example.exceptions.DescuentoSuperaTopeException;

public class DescuentoPorcentajeConTope extends Descuento {
    private static float tope = 50;
    public DescuentoPorcentajeConTope(float valor) {
        this.setValorDesc(valor);
    }
    @Override
    public float valorFinal(float valorInicial) throws DescuentoSuperaTopeException {
        if (this.getValorDesc() > tope) {
            throw new DescuentoSuperaTopeException();
        }
        return valorInicial - (valorInicial * this.getValorDesc() / 100);
    }
}
