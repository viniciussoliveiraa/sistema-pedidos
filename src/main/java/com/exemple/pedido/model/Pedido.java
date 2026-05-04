package com.exemple.pedido.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valor;

    private String status;

    private String tipoFrete;
}