package com.exemple.pedido.state;

import com.exemple.pedido.model.Pedido;

public class AguardandoPagamento implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        pedido.setStatus("PAGO");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setStatus("CANCELADO");
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new RuntimeException("Pedido precisa ser pago antes de enviar");
    }
}