package com.exemple.pedido.state;

import com.exemple.pedido.model.Pedido;

public class Pago implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        throw new RuntimeException("Pedido já está pago");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new RuntimeException("Pedido pago não pode ser cancelado");
    }

    @Override
    public void enviar(Pedido pedido) {
        pedido.setStatus("ENVIADO");
    }
}