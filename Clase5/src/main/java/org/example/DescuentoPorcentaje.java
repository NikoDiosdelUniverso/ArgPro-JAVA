package org.example;

public class DescuentoPorcentaje extends Descuento{

    public DescuentoPorcentaje(float valor) {
        this.setValorDesc(valor);
    }
    @Override
    public float valorFinal(float valorInicial) {
        return valorInicial - (valorInicial * this.getValorDesc() / 100);
    }
}
