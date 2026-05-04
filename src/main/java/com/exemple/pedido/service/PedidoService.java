package com.exemple.pedido.service;

import com.exemple.pedido.model.Pedido;
import com.exemple.pedido.repository.PedidoRepository;
import com.exemple.pedido.state.*;
import com.exemple.pedido.strategy.*;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    private EstadoPedido getEstado(String status) {
        return switch (status) {
            case "PAGO" -> new Pago();
            case "ENVIADO" -> new Enviado();
            case "CANCELADO" -> new Cancelado();
            default -> new AguardandoPagamento();
        };
    }

    private FreteStrategy getFrete(String tipo) {
        return switch (tipo) {
            case "AEREO" -> new FreteAereo();
            default -> new FreteTerrestre();
        };
    }

    public Pedido criar(Pedido pedido) {
        pedido.setStatus("AGUARDANDO");
        return repository.save(pedido);
    }

    public Pedido pagar(Long id) {
        Pedido pedido = repository.findById(id).orElseThrow();
        getEstado(pedido.getStatus()).pagar(pedido);
        return repository.save(pedido);
    }

    public Pedido cancelar(Long id) {
        Pedido pedido = repository.findById(id).orElseThrow();
        getEstado(pedido.getStatus()).cancelar(pedido);
        return repository.save(pedido);
    }

    public Pedido enviar(Long id) {
        Pedido pedido = repository.findById(id).orElseThrow();
        getEstado(pedido.getStatus()).enviar(pedido);
        return repository.save(pedido);
    }

    public double calcularFrete(Long id) {
        Pedido pedido = repository.findById(id).orElseThrow();
        return getFrete(pedido.getTipoFrete()).calcular(pedido.getValor());
    }
}