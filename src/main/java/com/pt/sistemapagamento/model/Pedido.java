package com.pt.sistemapagamento.model;

import java.math.BigDecimal;

public class Pedido {

    private Long id;

    private BigDecimal valor;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    // Constructors

    public Pedido() {
    }

    public Pedido(Long id, BigDecimal valor) {
        this.id = id;
        this.valor = valor;
    }

    // toString

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", valor=" + valor +
                '}';
    }


}
