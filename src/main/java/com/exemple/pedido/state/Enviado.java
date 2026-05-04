package com.exemple.pedido.state;

import com.exemple.pedido.model.Pedido;

public class Enviado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        throw new RuntimeException("Pedido já enviado");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new RuntimeException("Pedido já enviado");
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new RuntimeException("Pedido já enviado");
    }
}