package com.exemple.pedido.state;

import com.exemple.pedido.model.Pedido;

public interface EstadoPedido {

    void pagar(Pedido pedido);

    void cancelar(Pedido pedido);

    void enviar(Pedido pedido);
}