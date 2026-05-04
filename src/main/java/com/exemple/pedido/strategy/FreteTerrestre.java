package com.exemple.pedido.strategy;

public class FreteTerrestre implements FreteStrategy {

    @Override
    public double calcular(double valor) {
        return valor * 0.05;
    }
}