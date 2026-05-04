package com.exemple.pedido.strategy;

public class FreteAereo implements FreteStrategy {

    @Override
    public double calcular(double valor) {
        return valor * 0.10;
    }
}