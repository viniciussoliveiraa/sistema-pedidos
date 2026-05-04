package com.exemple.pedido.controller;

import com.exemple.pedido.model.Pedido;
import com.exemple.pedido.service.PedidoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return service.criar(pedido);
    }

    @PostMapping("/{id}/pagar")
    public Pedido pagar(@PathVariable Long id) {
        return service.pagar(id);
    }

    @PostMapping("/{id}/cancelar")
    public Pedido cancelar(@PathVariable Long id) {
        return service.cancelar(id);
    }

    @PostMapping("/{id}/enviar")
    public Pedido enviar(@PathVariable Long id) {
        return service.enviar(id);
    }

    @GetMapping("/{id}/frete")
    public double frete(@PathVariable Long id) {
        return service.calcularFrete(id);
    }
}