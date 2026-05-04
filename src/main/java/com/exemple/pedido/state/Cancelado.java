package com.exemple.pedido.state;

import com.exemple.pedido.model.Pedido;

public class Cancelado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        throw new RuntimeException("Pedido cancelado");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new RuntimeException("Pedido já cancelado");
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new RuntimeException("Pedido cancelado");
    }
}